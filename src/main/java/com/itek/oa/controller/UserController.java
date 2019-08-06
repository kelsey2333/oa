/**
 * @Author wpzhang
 * @Date 2019/7/9
 * @Description
 */
package com.itek.oa.controller;

import com.itek.oa.commons.ResultCode;
import com.itek.oa.commons.ServiceResult;
import com.itek.oa.domain.User;
import com.itek.oa.service.UserService;
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
 * @create: 2019-07-09 11:52
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    //添加页面,只接受get请求方式
    @RequestMapping(value = "/add.do",method = RequestMethod.GET)
    public String addPage(){
        return "user/add";
    }

    //接收添加用户界面提交过来的数据 只接受票post方式
    @RequestMapping(value = "/add.do" , method = RequestMethod.POST)
    public String addUser(User user, Model model){
       ServiceResult<String> result =  userService.addNewUser(user);
       if (result.getCode() == ResultCode.SUCCESS.getCode()){
           //保存成功就写出提示
            model.addAttribute("msg","添加用户成功！");
       }else{
           //保存失败就将字符串形式的data写出：添加用户失败！
           model.addAttribute("msg",result.getData());
       }
       return "user/add";
    }


}