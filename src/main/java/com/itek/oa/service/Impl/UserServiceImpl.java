/**
 * @Author wpzhang
 * @Date 2019/7/9
 * @Description
 */
package com.itek.oa.service.Impl;

import com.itek.oa.commons.ResultCode;
import com.itek.oa.commons.ServiceResult;
import com.itek.oa.dao.UserDao;
import com.itek.oa.domain.User;
import com.itek.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-09 14:17
 **/
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public ServiceResult<String> addNewUser(User user) {
        ServiceResult<String> result = new ServiceResult<>();
        int count = userDao.insertUser(user);
        if (count != 1){
            result.setServiceResult(ResultCode.FAIL);
            result.setData("添加用户失败！");
        }
        return result;
    }

    @Override
    public ServiceResult<User> checkLogin(User user) {
       ServiceResult<User> result =  new ServiceResult<>();
       User user1 =  userDao.checkLogin(user);
       if(user1 == null ){
           result.setServiceResult(ResultCode.USERNAME_OR_PASSWORD_ERROR);
       }else{
           result.setData(user1);
       }
       return result;
    }
}