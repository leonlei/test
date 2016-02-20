package com.leon.service;

import com.leon.model.User;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/2
 */
public interface TestService {

    public void test() throws Exception;

    public User getUser(Integer userId);
}
