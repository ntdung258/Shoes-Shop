package shoesShop.dao;

import shoesShop.entities.User;

public interface UserDao {
	public boolean addUser(User user);
	public User getUserByUserName(String userName);
}
