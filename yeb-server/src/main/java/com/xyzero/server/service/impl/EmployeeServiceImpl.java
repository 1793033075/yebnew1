package com.xyzero.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

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
        //查到值
        List<Map<String, Object>> maps = employeeMapper.selectMaps(new QueryWrapper<Employee>().select("max(workID)"));
        //转换类型+1
        String workId = String.format("%08d", Integer.parseInt(maps.get(0).get("max(workID)").toString()) + 1);
        return RespBean.success(workId);
    }

    @Override
    public RespBean addEmp(Employee employee) {
        //处理合同期限 保留两位小数
        LocalDate beginContract =employee.getBeginContract();
        LocalDate endContract = employee.getEndContract();
        long days = beginContract.until(endContract, ChronoUnit.DAYS);

        DecimalFormat decimalFormat = new DecimalFormat("##.00");

        employee.setContractTerm(Double.parseDouble(decimalFormat.format(days / 365.00)));

        if(1== employeeMapper.insert(employee)){
            return RespBean.success("添加成功");
        }else{
            return RespBean.error("添加失败");
        }

    }

    /**
     * 导出查询
     * @param id
     * @return
     */
    @Override
    public List<Employee> getEmployee(Integer id) {
        List<Employee> employeeList = employeeMapper.getEmployee(id);
        return employeeList;
    }
}
