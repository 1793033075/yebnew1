package com.xyzero.server.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyzero.server.pojo.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.record.DVALRecord;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangshumin
 * @since 2022-11-04
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     * 获取所有员工（分页）
     * @param page
     * @param employee
     * @param beginDateScope
     * @return
     */
    IPage<Employee> getEmployeeListByPage(Page<Employee> page, @Param("employee") Employee employee, @Param("beginDateScope") LocalDate beginDateScope[]);

    List<Employee> getEmployee(Integer id);
}
