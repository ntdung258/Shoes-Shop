package shoesShop.dao.impl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shoesShop.dao.BillDao;
import shoesShop.entities.Bill;
import shoesShop.entities.Bill_Detail;

@Repository
public class BillDaoImpl implements BillDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean createBill(Bill bill) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(bill);
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
	public boolean addBillDetail(Bill_Detail bill_Detail) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(bill_Detail);
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
	public List<Bill_Detail> getBillDetail(Integer id_Bill) {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("FROM Bill_Detail WHERE id_Bill = :IdBill")
					.setParameter("IdBill", id_Bill)
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
	public List<Bill> getIdBill(Integer id_User) {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("FROM Bill WHERE id_User = :IdUser ORDER BY id DESC")
					.setParameter("IdUser", id_User)
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
