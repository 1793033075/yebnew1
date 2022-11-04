package com.xyzero.server.service.impl;

import com.xyzero.server.pojo.Employee;
import com.xyzero.server.mapper.EmployeeMapper;
import com.xyzero.server.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
