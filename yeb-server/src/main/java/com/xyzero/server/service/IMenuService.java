package com.xyzero.server.service;

import com.xyzero.server.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangshumin
 * @since 2022-02-27
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 根据用户id获取菜单列表
     * @return
     */
    List<Menu> getMenusByAdminId();

    /**
     * 查询所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}
