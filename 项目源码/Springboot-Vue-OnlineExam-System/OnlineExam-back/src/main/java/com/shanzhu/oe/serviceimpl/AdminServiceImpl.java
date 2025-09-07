package com.shanzhu.oe.serviceimpl;

import com.shanzhu.oe.entity.Admin;
import com.shanzhu.oe.mapper.AdminMapper;
import com.shanzhu.oe.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员 服务层实现类
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;

    /**
     * 查询所有管理员
     *
     * @return 管理员
     */
    @Override
    public List<Admin> findAll() {
        return adminMapper.findAll();
    }

    /**
     * 通过管理员id查询
     *
     * @param adminId 管理员id
     * @return 管理员
     */
    @Override
    public Admin findById(Integer adminId) {
        return adminMapper.findById(adminId);
    }

    /**
     * 通过管理员id删除
     *
     * @param adminId 管理员id
     * @return 结果
     */
    @Override
    public Integer deleteById(Integer adminId) {
        return adminMapper.deleteById(adminId);
    }

    /**
     * 更新管理员
     *
     * @param admin 管理员信息
     * @return 结果
     */
    @Override
    public Integer update(Admin admin) {
        return adminMapper.update(admin);
    }

    /**
     * 添加管理员
     *
     * @param admin 管理员信息
     * @return 结果
     */
    @Override
    public Integer add(Admin admin) {
        return adminMapper.add(admin);
    }

    /**
     * 更新密码
     *
     * @param adminId 管理员id
     * @param newPsw 新密码
     * @param oldPsw 旧密码
     * @return 结果
     */
    @Override
    public Object resetPsw(Integer adminId, String newPsw, String oldPsw) {
        Admin admin = findById(adminId);

        if(!admin.getPwd().equals(oldPsw)) {
            return "原密码错误";
        }
        admin.setPwd(String.valueOf(newPsw));
        update(admin);
        return Boolean.TRUE;
    }


}
