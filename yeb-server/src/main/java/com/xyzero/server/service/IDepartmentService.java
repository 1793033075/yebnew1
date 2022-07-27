package com.xyzero.server.service;

import com.xyzero.server.pojo.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xyzero.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangshumin
 * @since 2022-07-27
 */
public interface IDepartmentService extends IService<Department> {

    /**
     *
     * @return
     */
    List<Department> getAllDepartments();

    /**
     * 添加部门
     * @param department
     * @return
     */
    RespBean addDep(Department department);

    RespBean delDep(Integer id);
}
