package Dao;

import java.util.List;

import Entity.ProductEntity;

public interface StatisticalDao {
	Long countProduct();
	Long countUser();
	Long countBill();
	Long revenue();
}
