package com.xyzero.server.controller;


import com.xyzero.server.pojo.Menu;
import com.xyzero.server.service.IAdminService;
import com.xyzero.server.service.IMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wangshumin
 * @since 2022-02-27
 */
@RestController
@RequestMapping("/system/cfg")
public class MenuController {
    @Autowired
    private IAdminService adminService;
    @Autowired
    private IMenuService menuService;

    @ApiOperation(value = "通过用户id查询菜单列表")
    @GetMapping("/menu")
    public List<Menu> getMenusByAdminId() {
        return menuService.getMenusByAdminId();
    }


}
