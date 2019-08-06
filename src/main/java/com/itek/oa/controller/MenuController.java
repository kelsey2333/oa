/**
 * @Author wpzhang
 * @Date 2019/7/9
 * @Description
 */
package com.itek.oa.controller;

import com.itek.oa.commons.ResultCode;
import com.itek.oa.commons.ServiceResult;
import com.itek.oa.domain.Menu;
import com.itek.oa.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-09 16:47
 **/
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    @Qualifier("menuService")
    private MenuService menuService;
    @RequestMapping(value = "/add.do", method = RequestMethod.GET)
    public String addPage(){
        return "menu/add";
    }
    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    public String addMenu(Menu menu, Model model){
       ServiceResult<String> result =  menuService.addNewMenu(menu);
       if (result.getCode() == ResultCode.SUCCESS.getCode()){
           model.addAttribute("msg","添加菜单成功！");
       }else{
           model.addAttribute("msg",result.getData());
       }
        return "menu/add";
    }
}