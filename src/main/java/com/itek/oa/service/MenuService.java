/**
 * @Author wpzhang
 * @Date 2019/7/9
 * @Description
 */
package com.itek.oa.service;

import com.itek.oa.commons.ServiceResult;
import com.itek.oa.domain.Menu;

import java.util.List;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-09 17:50
 **/
public interface MenuService {
    ServiceResult<String> addNewMenu(Menu menu);

    ServiceResult<List<Menu>> findTopMenusByUserId(Integer userId);
}