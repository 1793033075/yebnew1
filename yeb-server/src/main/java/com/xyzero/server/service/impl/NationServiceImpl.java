package com.xyzero.server.service.impl;

import com.xyzero.server.pojo.Nation;
import com.xyzero.server.mapper.NationMapper;
import com.xyzero.server.service.INationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangshumin
 * @since 2022-11-04
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

}
