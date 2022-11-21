package shoesShop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shoesShop.dao.UserDao;
import shoesShop.entities.Product;
import shoesShop.entities.User;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public boolean addUser(User user) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
		
	}


	@Override
	public User getUserByUserName(String  userName) {
		Session session = sessionFactory.openSession();
		try {
			User user = (User) session.createQuery("FROM User WHERE userName = :username")
					.setParameter("username", userName)
					.uniqueResult();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}
	
	
}
