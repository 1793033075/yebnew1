package com.xyzero.server.service;

import com.xyzero.server.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xyzero.server.pojo.RespBean;
import com.xyzero.server.pojo.RespPageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangshumin
 * @since 2022-11-04
 */
public interface IEmployeeService extends IService<Employee> {

    /**
     * 分页查询员工列表
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     */
    RespPageBean getEmployeeListByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);

    /**
     * 获取工号
     * @return
     */
    RespBean maxWorkID();

    /**
     * 添加员工
     * @param employee
     * @return
     */
    RespBean addEmp(Employee employee);

    /**
     * 导出员工
     * @param
     */
    List<Employee> getEmployee(Integer id);
}
