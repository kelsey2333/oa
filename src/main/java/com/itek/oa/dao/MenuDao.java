/**
 * @Author wpzhang
 * @Date 2019/7/9
 * @Description
 */
package com.itek.oa.dao;

import com.itek.oa.commons.ServiceResult;
import com.itek.oa.domain.Menu;

import java.util.List;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-09 11:42
 **/
public interface MenuDao {
    int insertMenu(Menu menu);

    List<Menu> selectTopMenusByUserId(Integer userId);

    List<Menu> selectSubMenus(int menuId);
}