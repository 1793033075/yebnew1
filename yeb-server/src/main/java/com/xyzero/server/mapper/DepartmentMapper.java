package com.xyzero.server.mapper;

import com.xyzero.server.pojo.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangshumin
 * @since 2022-07-27
 */
public interface DepartmentMapper extends BaseMapper<Department> {
    /**
     * 获取所有部门
     */

    List<Department> getAllDepartments(Integer parentId);

    /**
     * 添加部门
     * @param department
     */
    void addDep(Department department);
}
