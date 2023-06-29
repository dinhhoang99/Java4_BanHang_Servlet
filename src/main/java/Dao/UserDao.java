package Dao;

import java.util.List;

import Entity.UserEntity;

public interface UserDao {
	UserEntity findById(int id);
	UserEntity findByEmail(String email);
	UserEntity findByUserName(String userName);
	UserEntity findByUserNameAndPassword(String userName, String passWord);
	UserEntity findByEmailAndPassword(String email, String passWord);
	UserEntity findByUserNameAndEmail(String username, String email);
	List<UserEntity> findAll();
	UserEntity create(UserEntity entity);
	UserEntity update(UserEntity entity);
	UserEntity delete(UserEntity entity);
}
