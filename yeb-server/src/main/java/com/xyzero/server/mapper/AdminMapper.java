package com.xyzero.server.mapper;

import com.xyzero.server.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyzero.server.pojo.Menu;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangshumin
 * @since 2022-02-19
 */
@Component
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 根据用户id获取菜单列表
     * @param id
     */
    List<Menu> getMenusByAdminId(Integer id);
}
