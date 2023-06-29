package Services.Impl;

import Dao.StatisticalDao;
import Dao.Impl.StatisticalDaoImpl;
import Services.StatisticalServices;

public class StatisticalServicesImpl implements StatisticalServices{
	StatisticalDao dao = new StatisticalDaoImpl();
	@Override
	public Long countProduct() {
		return dao.countProduct();
	}
	@Override
	public Long countUser() {
		return dao.countUser();
	}
	@Override
	public Long countBill() {
		return dao.countBill();
	}
	@Override
	public Long revenue() {
		return dao.revenue();
	}

}
