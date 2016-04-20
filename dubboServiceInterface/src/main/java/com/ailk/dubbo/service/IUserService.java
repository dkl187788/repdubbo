package com.ailk.dubbo.service;

import java.util.List;
import java.util.Map;

import com.ailk.dubbo.model.User;

public interface IUserService {

	User getUserById(int userId);

	/**
	 * 
	 * @param param
	 *            Map中的key要与数据库表中的字段名相同
	 * @return
	 */
	User getUserByMapSql(Map<String, String> param);

	List<User> getUserListByMapSql(Map<String, String> param);
}
