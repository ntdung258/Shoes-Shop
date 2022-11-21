package shoesShop.dao.impl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shoesShop.dao.TypeDao;
import shoesShop.entities.Type;

@Repository
public class TypeDaoImpl implements TypeDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Type> getTypes() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("FROM Type").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public Type getTypeById(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			Type type = session.get(Type.class, id);
			return type;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}
}
