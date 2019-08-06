/**
 * @Author wpzhang
 * @Date 2019/7/9
 * @Description
 */
package com.itek.oa.controller;

import com.itek.oa.commons.ResultCode;
import com.itek.oa.commons.ServiceResult;
import com.itek.oa.domain.Role;
import com.itek.oa.service.RoleService;
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
 * @create: 2019-07-09 15:39
 **/
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;
    @RequestMapping(value = "/add.do",method = RequestMethod.GET)
    public String addPage(){
        return "role/add";
    }
    @RequestMapping(value = "/add.do",method = RequestMethod.POST)
    public String addRole(Role role , Model model){
        System.out.println(role+"===========");
       ServiceResult<String> result =  roleService.addNewRole(role);
       if (result.getCode() == ResultCode.SUCCESS.getCode()){
           model.addAttribute("msg","添加角色成功！");
       }else{
           model.addAttribute("msg",result.getData());
       }
        return "role/add";
    }
}