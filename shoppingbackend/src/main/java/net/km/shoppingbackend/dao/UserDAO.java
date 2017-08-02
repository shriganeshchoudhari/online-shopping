package net.km.shoppingbackend.dao;

import java.util.List;

import net.km.shoppingbackend.dto.Address;
import net.km.shoppingbackend.dto.Cart;
import net.km.shoppingbackend.dto.User;

public interface UserDAO {

	// add an user
	boolean addUser(User user);
	User getByEmail(String email);
	
	// add an address
	boolean addAddress(Address address);
	// alternative
	 Address getBillingAddress(int userId);
	 List<Address> listShippingAddresses(int userId);
	
/*	
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
*/
	
	// udpate a cart
	boolean updateCart(Cart cart);
}
