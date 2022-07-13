package com.xyzero.server.controller;

import com.xyzero.server.pojo.Menu;
import com.xyzero.server.pojo.RespBean;
import com.xyzero.server.pojo.Role;
import com.xyzero.server.service.IMenuService;
import com.xyzero.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/system/config/permission")
public class PermissionController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IMenuService menuService;

    @ApiOperation(value = "获取所有角色")
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.list();
    }
    @ApiOperation(value = "添加角色")
    @PostMapping("/")
    public RespBean addRoles(@RequestBody Role role){
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        if(roleService.save(role)){
            return RespBean.success("添加成功");
        }else{
            return RespBean.error("添加失败");
        }
    }
    @ApiOperation(value = "删除角色")
    @DeleteMapping("role/{rid}")
    public RespBean delRole(@PathVariable Integer rid){
        if(roleService.removeById(rid)){
            return RespBean.success("删除成功");
        }else{
            return RespBean.error("删除失败");
        }
    }
    @ApiOperation(value = "修改角色")
    @PutMapping("/")
    public RespBean updateRoles(Role role){
        if (roleService.updateById(role)) {
            return RespBean.success("修改成功");
        }else{
            return RespBean.error("修改失败");
        }
    }
    @ApiOperation(value = "批量删除")
    @DeleteMapping("/")
    public RespBean delRoles(Integer[] roles){
        if (roleService.removeByIds(Arrays.asList(roles))) {
            return RespBean.success("删除成功");
        }else{
            return RespBean.error("删除失败!");
        }
    }
    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

}
