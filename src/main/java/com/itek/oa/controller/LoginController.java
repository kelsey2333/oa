/**
 * @Author wpzhang
 * @Date 2019/7/10
 * @Description
 */
package com.itek.oa.controller;

import com.itek.oa.commons.ResultCode;
import com.itek.oa.commons.ServiceResult;
import com.itek.oa.domain.Menu;
import com.itek.oa.domain.User;
import com.itek.oa.service.MenuService;
import com.itek.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-10 06:17
 **/
@Controller
public class LoginController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @Autowired
    @Qualifier("menuService")
    private MenuService menuService;
    @RequestMapping(value = "/login.do",method = RequestMethod.GET)
    public String addPage(){
        return "login";
    }
    @RequestMapping(value = "/checkLogin.do", method = RequestMethod.POST)
    public String checkLogin(User user, HttpSession session, Model model){
       ServiceResult<User> result =  userService.checkLogin(user);
       if (result.getCode() == ResultCode.SUCCESS.getCode()){
//           DigestUtils.md5DigestAsHex()
           //登录成功将账号密码绑定到session中
           session.setAttribute("loginUser",result.getData());
           //并将所有顶级菜单添加到session中
          ServiceResult<List<Menu>> menuResult =  menuService.findTopMenusByUserId(result.getData().getId());
          if (menuResult.getCode() == ResultCode.SUCCESS.getCode()){
              session.setAttribute("topMenus",menuResult.getData());
          }
           return "redirect:/user/add.do";
       }else{
           model.addAttribute("msg",result.getMsg());
           return "login";
       }
    }

    @RequestMapping("/loginout.do")
    public String loginout(HttpSession session){
        session.invalidate();
        return "login";
    }


}