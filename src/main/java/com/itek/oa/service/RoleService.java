/**
 * @Author wpzhang
 * @Date 2019/7/9
 * @Description
 */
package com.itek.oa.service;

import com.itek.oa.commons.ServiceResult;
import com.itek.oa.domain.Role;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-09 15:49
 **/
public interface RoleService {
    ServiceResult<String> addNewRole(Role role);
}