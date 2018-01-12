package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.CategoryDao;
import com.model.Category;
import com.model.Product;

@Repository
@Service
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public CategoryDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public void insertCategory(Category category){
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(category);
		session.getTransaction().commit();
		
	}
	
	public List<Category> retrive(){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Category> li=session.createQuery("from Category").list();
		session.getTransaction().commit();
		return li;
		
	}
	
	public Category findByCatId(int cid)
	{
		Session session=sessionFactory.openSession();
		Category c=null;
		try
		{
			session.beginTransaction();
			c=session.get(Category.class, cid);
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		}
		
		return c;
	}
	
	
	public void updateCategory(Category cc)
	{
		Session session	=sessionFactory.openSession();
		session.beginTransaction();
		session.update(cc);
		session.getTransaction().commit();
	}
	
	public void deleteCategory(int cid)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Category cc=(Category)session.get(Category.class, cid);
		session.delete(cc);
		session.getTransaction().commit();
	}
}