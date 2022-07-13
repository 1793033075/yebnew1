package com.xyzero.server.service;

import com.xyzero.server.pojo.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xyzero.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangshumin
 * @since 2022-07-13
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateRoleMenus(Integer rid, Integer[] mids);
}
