package com.xyzero.server.service;

import com.xyzero.server.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xyzero.server.pojo.Menu;
import com.xyzero.server.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangshumin
 * @since 2022-02-19
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 登录后返回token
     *
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取当前登录用户信息
     * @param username
     * @return
     */
    Admin getAdminByUsername(String username);

}
