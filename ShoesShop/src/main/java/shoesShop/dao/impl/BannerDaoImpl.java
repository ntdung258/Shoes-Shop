package shoesShop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shoesShop.dao.BannerDao;
import shoesShop.entities.Banner;

@Repository
public class BannerDaoImpl implements BannerDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Banner> getBanners() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("FROM Banner").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}
