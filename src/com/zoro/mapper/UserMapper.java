package com.zoro.mapper;

import java.util.List;

import com.zoro.domain.User;
import com.zoro.domain.UserQueryVO;

public interface UserMapper {
    //由id查询用户
	public User findUserById(int id);

	
	//插入用户
	public void insertUser(User user);
	
	//综合查询
	public List<User> findUserList(UserQueryVO vo);
	
	//综合查询2
	public List<User> findUserList2(UserQueryVO vo);
	
	//综合查询用户总数
	public int findUserCount(UserQueryVO vo);
	
	//用resultMap返回结果集
	public User findUserRstMap(int id);
}
