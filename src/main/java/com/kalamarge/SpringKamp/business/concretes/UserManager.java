package com.kalamarge.SpringKamp.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalamarge.SpringKamp.business.abstracts.UserService;
import com.kalamarge.SpringKamp.core.dataAccess.UserDao;
import com.kalamarge.SpringKamp.core.entities.User;
import com.kalamarge.SpringKamp.core.utilities.results.DataResult;
import com.kalamarge.SpringKamp.core.utilities.results.Result;
import com.kalamarge.SpringKamp.core.utilities.results.SuccessDataResult;
import com.kalamarge.SpringKamp.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}
	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email));
	}

}
