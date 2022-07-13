package com.xyzero.server.service.impl;

import com.xyzero.server.pojo.Role;
import com.xyzero.server.mapper.RoleMapper;
import com.xyzero.server.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangshumin
 * @since 2022-07-12
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
