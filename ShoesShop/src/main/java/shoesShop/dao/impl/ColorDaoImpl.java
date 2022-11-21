package shoesShop.dao.impl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shoesShop.dao.ColorDao;
import shoesShop.entities.Color_Product;


@Repository
public class ColorDaoImpl implements ColorDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Color_Product> getColorsProduct() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("FROM Color_Product").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public Color_Product getColorProductById(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			Color_Product color = session.get(Color_Product.class, id);
			return color;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}
}
