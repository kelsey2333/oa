/**
 * @Author wpzhang
 * @Date 2019/7/9
 * @Description
 */
package com.itek.oa.domain;

/**
 * @program: oa
 * @description:
 * @author: wpzhang
 * @create: 2019-07-09 11:38
 **/
public class Role {
    public  Role(){}
    private Integer id;
    private String roleName;
    private String status;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Role(Integer id, String roleName, String status) {
        this.id = id;
        this.roleName = roleName;
        this.status = status;
    }
}