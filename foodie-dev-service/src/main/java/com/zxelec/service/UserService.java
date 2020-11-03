package com.zxelec.service;

/**
 * @author somewang
 */
public interface UserService {

    /**
     * 查询用户名是否存在
     *
     * @param username
     * @return
     */
    boolean queryUsernameIsExist(String username);

}
