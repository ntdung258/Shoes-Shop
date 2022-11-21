package shoesShop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shoesShop.dao.ImageDao;
import shoesShop.entities.Image_Product_Detail;

@Repository
public class ImageDaoImpl implements ImageDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Image_Product_Detail> getImageByIdProduct(Integer id_Product) {
		Session session = sessionFactory.openSession();
		try {			
			List list = session.createQuery("FROM Image_Product_Detail WHERE id_Product = :IdProduct")
					.setParameter("IdProduct", id_Product)
					.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}
