package com.xyzero.server.mapper;

import com.xyzero.server.pojo.AdminRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xyzero.server.pojo.RespBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangshumin
 * @since 2022-11-04
 */
@Component
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    /**
     *
     * @param adminId
     * @param rids
     * @return
     */
    Integer addAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
