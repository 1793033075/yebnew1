package com.xyzero.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.xyzero.server.AdminUtils;
import com.xyzero.server.config.security.JwtTokenUtil;
import com.xyzero.server.mapper.AdminRoleMapper;
import com.xyzero.server.pojo.Admin;
import com.xyzero.server.mapper.AdminMapper;
import com.xyzero.server.pojo.AdminRole;
import com.xyzero.server.pojo.Menu;
import com.xyzero.server.pojo.RespBean;
import com.xyzero.server.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.Security;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangshumin
 * @since 2022-02-19
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    /**
     * 登录之后返回token
     *
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    @Override
    public RespBean login(String username, String password, String code, HttpServletRequest request) {
        //System.out.println("用户名："+username);
        String captcha = (String)request.getSession().getAttribute("captcha");
        if(StringUtils.isEmpty(code)||!captcha.equalsIgnoreCase(code)){
            return RespBean.error("验证码错误,请重新输入");
        }
        //登录
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null == userDetails || !passwordEncoder.matches(password, userDetails.getPassword())) {
            return RespBean.error("用户名或密码不正确");
        }
        if (!userDetails.isEnabled()) {
            return RespBean.error("账号被禁用，请联系管理员");
        }
        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //生成token
        String token = jwtTokenUtil.generateToken(userDetails);

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return RespBean.success("登录成功",tokenMap);
    }


    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */

    @Override
    public Admin getAdminByUsername(String username) {
        System.out.println("用户名是"+username);
        Admin admin = adminMapper.selectOne(new QueryWrapper<Admin>().eq("username", username).eq("enabled", true));
        System.out.println(admin.getPassword());
        return admin;
    }

    /**
     * 获取所有操作员，不包括自己
     * @param keywords
     * @return
     */
    @Override
    public List<Admin> getAllAdmins(String keywords) {
        return adminMapper.getAllAdmins(AdminUtils.getCurrentAdmin().getId(),keywords);
    }

    /**
     * 更新操作员的角色
     * @param adminId
     * @param rids
     * @return
     */
    @Override
    @Transactional
    public RespBean addAdminRole(Integer adminId, Integer[] rids) {
        //先删除操作员对应角色
        adminRoleMapper.delete(new QueryWrapper<AdminRole>().eq("adminid",adminId));
        //新增操作员对应角色
        Integer result = adminRoleMapper.addAdminRole(adminId, rids);
        if(rids.length==result){
            return RespBean.success("更新成功");
        }else{
            return RespBean.error("更新失败");
        }
    }


}
