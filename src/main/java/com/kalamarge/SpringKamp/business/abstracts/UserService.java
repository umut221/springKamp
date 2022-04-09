package com.kalamarge.SpringKamp.business.abstracts;

import com.kalamarge.SpringKamp.core.entities.User;
import com.kalamarge.SpringKamp.core.utilities.results.DataResult;
import com.kalamarge.SpringKamp.core.utilities.results.Result;

public interface UserService {
	Result add(User user);
	DataResult<User> findByEmail(String email);
}