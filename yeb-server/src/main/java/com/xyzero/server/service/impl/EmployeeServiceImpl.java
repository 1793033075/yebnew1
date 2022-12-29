package com.xyzero.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyzero.server.pojo.Employee;
import com.xyzero.server.mapper.EmployeeMapper;
import com.xyzero.server.pojo.RespBean;
import com.xyzero.server.pojo.RespPageBean;
import com.xyzero.server.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangshumin
 * @since 2022-11-04
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 分页查询员工列表
     *
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     */
    @Override
    public RespPageBean getEmployeeListByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope) {

        //开启分页
        Page<Employee> page = new Page<>(currentPage, size);

        IPage<Employee> employeeIPage = employeeMapper.getEmployeeListByPage(page, employee, beginDateScope);

        RespPageBean respPageBean = new RespPageBean(employeeIPage.getTotal(), employeeIPage.getRecords());

        return respPageBean;
    }

    /**
     * 获取工号
     * @return
     */
    @Override
    public RespBean maxWorkID() {
        return null;
    }
}
