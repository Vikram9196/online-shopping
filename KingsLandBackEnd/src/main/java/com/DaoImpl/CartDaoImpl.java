package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.CartDao;
import com.model.Cart;

@Repository("CartDaoImpl")
public class CartDaoImpl implements CartDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public CartDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public void insertCart(Cart cart){
		
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.persist(cart);
		s.getTransaction().commit();
		
	}
	

	@SuppressWarnings("unchecked")
	public List<Cart> findByCartId(String userId)
	{
		Session session=sessionFactory.openSession();
		List<Cart> cr=null;
		try
		{
			session.beginTransaction();
			cr=(List<Cart>)session.createQuery("from Cart where userMailId=:email").setString("email", userId).list();
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return cr;
	}
	
	public Cart getCartById(int cartProductId, String userEmail){
		Session session=sessionFactory.openSession();
		Cart cr=null;
		session.beginTransaction();
		cr = (Cart)session.createQuery("from Cart where userMailId=:email and cartProductId=:pid").setString("email",userEmail).setInteger("pid", cartProductId).uniqueResult();
		session.getTransaction().commit();
		return cr;
	}
	
	public void deleteCart(int cartId)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Cart cr=(Cart)session.get(Cart.class, cartId);
		session.delete(cr);
		session.getTransaction().commit();
	}
	
	public void updateCart(Cart cr){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(cr);
		session.getTransaction().commit();
	}
	
	
	
	
	
}
