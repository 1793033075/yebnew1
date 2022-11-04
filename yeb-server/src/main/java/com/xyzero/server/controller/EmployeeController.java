package com.xyzero.server.controller;


import com.xyzero.server.pojo.Employee;
import com.xyzero.server.pojo.RespPageBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangshumin
 * @since 2022-11-04
 */
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {
    @ApiOperation(value = "分页查询员工列表")
    @GetMapping("/")
    public RespPageBean getEmployeeList(@RequestParam(defaultValue = "1") Integer currentPage,
                                        @RequestParam(defaultValue = "10") Integer size,
                                        Employee employee,
                                        LocalDate [] localDateScope){
        return new RespPageBean();

    }

}
