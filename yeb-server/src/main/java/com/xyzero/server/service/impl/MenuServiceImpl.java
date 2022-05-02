package com.xyzero.server.service.impl;

import com.xyzero.server.pojo.Admin;
import com.xyzero.server.pojo.Menu;
import com.xyzero.server.mapper.MenuMapper;
import com.xyzero.server.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangshumin
 * @since 2022-02-27
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;


    @Override
    /**
     * 根据用户id获取菜单列表
     */
    public List<Menu> getMenusByAdminId() {
        List<Menu> menusByAdminId = menuMapper.getMenusByAdminId(((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        return menusByAdminId;
    }
}
