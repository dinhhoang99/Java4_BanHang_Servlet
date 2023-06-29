package Dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Controller.JpaUtil;
import Dao.StatisticalDao;
import Entity.ProductEntity;

public class StatisticalDaoImpl implements StatisticalDao{
	EntityManager entity = JpaUtil.getEntityManager();

	@Override
	public Long countProduct() {
		String sql = "SELECT COUNT(p) FROM ProductEntity p WHERE p.isActive = 1";
		TypedQuery<Long> query = entity.createQuery(sql,Long.class);
		Long count = query.getSingleResult();
		return count;
	}

	@Override
	public Long countUser() {
		String sql = "SELECT COUNT(u) FROM UserEntity u WHERE u.isActive = 1";
		TypedQuery<Long> query = entity.createQuery(sql,Long.class);
		Long count = query.getSingleResult();
		return count;
	}

	@Override
	public Long countBill() {
		String sql = "SELECT COUNT(b) FROM BillEntity b";
		TypedQuery<Long> query = entity.createQuery(sql,Long.class);
		Long count = query.getSingleResult();
		return count;
	}

	@Override
	public Long revenue() {
		String sql = "SELECT SUM(b.totalBill) FROM BillEntity b";
		TypedQuery<Long> query = entity.createQuery(sql,Long.class);
		Long sum = query.getSingleResult();
		return sum;
	}

	
	

}
