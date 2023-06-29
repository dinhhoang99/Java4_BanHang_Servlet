package Dao.Impl;

import Dao.AbstractDao;
import Dao.CartDao;
import Entity.CartEntity;

public class CartDaoImpl extends AbstractDao<CartEntity> implements CartDao{

	@Override
	public CartEntity create(CartEntity cart) {
		return super.create(cart);
	}

}
