package com.zxelec.service.impl;

import com.zxelec.mapper.UsersMapper;
import com.zxelec.pojo.Users;
import com.zxelec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * UserServiceImpl
 *
 * @author vimicro
 * @date 2020/11/3
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("username", username);

        Users user = usersMapper.selectOneByExample(userExample);
        return user == null ? false : true;
    }
}
