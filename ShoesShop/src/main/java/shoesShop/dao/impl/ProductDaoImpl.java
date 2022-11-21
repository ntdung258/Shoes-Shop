package shoesShop.dao.impl;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shoesShop.dao.ProductDao;
import shoesShop.entities.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getProducts() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("FROM Product WHERE isDelete = 1 ").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Product> getProductsByType(Integer id_Type) {
		Session session = sessionFactory.openSession();
		try {			
			List list = session.createQuery("FROM Product WHERE id_Type = :IdType AND isDelete = 1")
					.setParameter("IdType", id_Type)
					.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public Product getProductsById(Integer id_Product) {
		Session session = sessionFactory.openSession();
		try {
			Product product =  (Product) session.createQuery("FROM Product WHERE id = :Id AND isDelete = 1")
					.setParameter("Id", id_Product)
					.uniqueResult();
			return product;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Product> getColorProductsByCode(String code) {
		Session session = sessionFactory.openSession();
		try {			
			List list = session.createQuery("FROM Product WHERE code = :Code AND isDelete = 1")
					.setParameter("Code", code)
					.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Product> getProductsByPage(Integer page) {
		Session session = sessionFactory.openSession();
		try {
			Query q = session.createQuery("FROM Product WHERE isDelete = 1");
			
			int max =5;
			q.setMaxResults(max);
			q.setFirstResult((page-1)*max);
			
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public Integer countProduct() {
		Session session = sessionFactory.openSession();
		try {
			Query q = session.createQuery("SELECT COUNT(*) FROM Product WHERE isDelete = 1");
			
			return Integer.parseInt(q.getSingleResult().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean addNewProduct(Product product) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(product);
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
	public boolean updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(product);
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
	public List<Product> getProductsTop4() {
		Session session = sessionFactory.openSession();
		try {
			Query q = session.createQuery("FROM Product WHERE isDelete = 1 ORDER BY id DESC");
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}


}
