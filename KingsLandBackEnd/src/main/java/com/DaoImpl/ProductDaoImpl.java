package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.ProductDao;
import com.model.Product;

@Repository
@Service
public class ProductDaoImpl  implements ProductDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public ProductDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public void insertProduct(Product product){
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(product);
		session.getTransaction().commit();
		
	}
	
	public List<Product> retrive(){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Product> li=session.createQuery("from Product").list();
		session.getTransaction().commit();
		return li;
		
	}
	
	public Product findByPID(int pid)
	{
		Session session=sessionFactory.openSession();
		Product prod=null;
		try
		{
			session.beginTransaction();
			prod=session.get(Product.class, pid);
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		}
		
		return prod;
	}
	
	
}
