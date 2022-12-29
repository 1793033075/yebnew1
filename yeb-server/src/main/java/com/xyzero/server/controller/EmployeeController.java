package com.xyzero.server.controller;


import com.xyzero.server.pojo.*;
import com.xyzero.server.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wangshumin
 * @since 2022-11-04
 */
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPoliticsStatusService politicsStatusService;
    @Autowired
    private IJoblevelService joblevelService;
    @Autowired
    private INationService nationService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IDepartmentService departmentService;

    @ApiOperation(value = "分页查询员工列表")
    @GetMapping("/")
    public RespPageBean getEmployeeList(@RequestParam(defaultValue = "1") Integer currentPage,
                                        @RequestParam(defaultValue = "10") Integer size,
                                        Employee employee,
                                        LocalDate[] beginDateScope) {
        RespPageBean employeeListByPage = employeeService.getEmployeeListByPage(currentPage, size, employee, beginDateScope);
        return employeeListByPage;

    }

    @ApiOperation(value = "获取所有政治面貌")
    @GetMapping("/politicStatus")
    public List<PoliticsStatus> getAllPolitics() {

        return politicsStatusService.list();
    }

    @ApiOperation(value = "获取所有职称")
    @GetMapping("/jobLevels")
    public List<Joblevel> getAlljobLevels() {
        return joblevelService.list();
    }

    @ApiOperation(value = "获取所有民族")
    @GetMapping("/nations")
    public List<Nation> getAllNations() {
        return nationService.list();
    }

    @ApiOperation(value = "获取所有职位")
    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        return positionService.list();
    }

    @ApiOperation(value = "获取所有部门")
    @GetMapping("/departments")
    public List<Department> getAlldepartments() {
        return departmentService.getAllDepartments();
    }

    @ApiOperation(value = "获取工号")
    @GetMapping("maxWorkID")
    public RespBean maxworkID(){
        return employeeService.maxWorkID();
    }


}
