package com.xyzero.server.mapper;

import com.xyzero.server.pojo.MenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangshumin
 * @since 2022-07-13
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     *
     * @param rid
     * @param mids
     * @return
     */
    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
