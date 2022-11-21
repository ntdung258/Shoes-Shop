package shoesShop.dao;
import java.util.List;

import shoesShop.entities.Bill;
import shoesShop.entities.Bill_Detail;


public interface BillDao {
	public boolean createBill(Bill bill);
	public boolean addBillDetail(Bill_Detail bill_Detail);
	
	public List<Bill_Detail> getBillDetail(Integer id_Bill);
	public List<Bill> getIdBill(Integer id_User);
}
