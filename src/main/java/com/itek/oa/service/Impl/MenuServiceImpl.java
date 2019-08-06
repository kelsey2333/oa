/**
 * @Author wpzhang
 * @Date 2019/7/9
 * @Description
 */
package com.itek.oa.service.Impl;

import com.itek.oa.commons.ResultCode;
import com.itek.oa.commons.ServiceResult;
import com.itek.oa.dao.MenuDao;
import com.itek.oa.domain.Menu;
import com.itek.oa.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-09 17:51
 **/
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public ServiceResult<String> addNewMenu(Menu menu) {
        ServiceResult<String> result = new ServiceResult<>();
       int count =  menuDao.insertMenu(menu);
       if (count != 1){
           result.setServiceResult(ResultCode.FAIL);
           result.setData("添加菜单失败！");
       }
       return result;
    }

    @Override
    public ServiceResult<List<Menu>> findTopMenusByUserId(Integer userId) {
        ServiceResult<List<Menu>> result = new ServiceResult<>();
        List<Menu> topMenus = menuDao.selectTopMenusByUserId(userId);
        //遍历所有的顶级菜单，找出pid与其id向同的子菜单
        for (Menu topMenu:topMenus){
            int menuId = topMenu.getId();
            List<Menu> subMenus = menuDao.selectSubMenus(menuId);
            topMenu.setSubMenus(subMenus);
        }
        result.setData(topMenus);
        return result;
    }
}