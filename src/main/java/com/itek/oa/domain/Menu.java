/**
 * @Author wpzhang
 * @Date 2019/7/9
 * @Description
 */
package com.itek.oa.domain;

import java.util.List;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-09 11:38
 **/
public class Menu {
    public Menu(){}
    private Integer id;
    private String menuName;
    private String menuIcon;
    private String menuLink;
    private Integer pid;

    private List<Menu> subMenus;

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuLink='" + menuLink + '\'' +
                ", pid=" + pid +
                ", subMenus=" + subMenus +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuLink() {
        return menuLink;
    }

    public void setMenuLink(String menuLink) {
        this.menuLink = menuLink;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Menu(Integer id, String menuName,List<Menu> subMenus, String menuIcon, String menuLink, Integer pid) {
        this.id = id;
        this.menuName = menuName;
        this.menuIcon = menuIcon;
        this.menuLink = menuLink;
        this.pid = pid;
        this.subMenus = subMenus;
    }
}