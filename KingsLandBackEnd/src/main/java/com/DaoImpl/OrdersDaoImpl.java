package com.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.OrderDao;
import com.model.Orders;

@Repository("OrdersDaoImpl")
public class OrdersDaoImpl implements OrderDao{


		@Autowired
		SessionFactory sessionFactory;
		
		@Autowired
		public OrdersDaoImpl(SessionFactory sessionFactory){
			this.sessionFactory=sessionFactory;
		}
		
		public void insertOrder(Orders order){
			
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.persist(order);
			session.getTransaction().commit();
			
		}

}
