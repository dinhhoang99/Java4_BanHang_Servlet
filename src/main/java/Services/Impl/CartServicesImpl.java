package Services.Impl;

import Dao.CartDao;
import Dao.Impl.CartDaoImpl;
import Entity.CartEntity;
import Services.CartServices;

public class CartServicesImpl implements CartServices{
	CartDao dao = new CartDaoImpl();
	@Override
	public CartEntity create(CartEntity cart) {
		return dao.create(cart);
	}

}
