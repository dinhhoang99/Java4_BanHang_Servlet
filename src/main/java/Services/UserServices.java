package Services;

import java.util.List;

import Entity.UserEntity;

public interface UserServices {
	UserEntity findById(int id);
	UserEntity findByEmail(String email);
	UserEntity findByUserName(String userName);
	UserEntity login(String userName, String passWord);
	UserEntity loginByEmailAndPassword(String email, String passWord);
	UserEntity findByUserNameAndEmail(String username, String email);
	UserEntity resetPassword(String userName);
	List<UserEntity> findAll();
	UserEntity create(String fullname,String username, String password, String email);
	UserEntity update(UserEntity entity);
	UserEntity delete(int id);
	
}
