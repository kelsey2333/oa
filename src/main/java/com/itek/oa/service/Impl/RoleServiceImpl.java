/**
 * @Author wpzhang
 * @Date 2019/7/9
 * @Description
 */
package com.itek.oa.service.Impl;

import com.itek.oa.commons.ResultCode;
import com.itek.oa.commons.ServiceResult;
import com.itek.oa.dao.RoleDao;
import com.itek.oa.domain.Role;
import com.itek.oa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-09 15:49
 **/
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public ServiceResult<String> addNewRole(Role role) {
        ServiceResult<String> result = new ServiceResult<>();
       int count =  roleDao.insertRole(role);
       if (count != 1){
           result.setServiceResult(ResultCode.FAIL);
           result.setData("添加角色失败");
       }
       return result;
    }
}