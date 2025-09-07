package com.shanzhu.oe.controller;

import com.shanzhu.oe.common.R;
import com.shanzhu.oe.entity.Admin;
import com.shanzhu.oe.service.AdminService;
import com.shanzhu.oe.util.ApiResultHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理员 控制层
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    /**
     * 查询所有管理员
     *
     * @return 管理员列表
     */
    @GetMapping("/admins")
    public R<List<Admin>> findAll(){
        return ApiResultHandler.success(adminService.findAll());
    }

    /**
     * 通过管理员id查询
     *
     * @param adminId 管理员id
     * @return 管理员
     */
    @GetMapping("/admin/{adminId}")
    public R<Admin> findById(@PathVariable("adminId") Integer adminId){
        return ApiResultHandler.success(adminService.findById(adminId));
    }

    /**
     * 通过管理员id删除
     *
     * @param adminId 管理员id
     * @return 结果
     */
    @DeleteMapping("/admin/{adminId}")
    public R deleteById(@PathVariable("adminId") Integer adminId){
        adminService.deleteById(adminId);
        return ApiResultHandler.success();
    }

    /**
     * 更新管理员
     *
     * @param adminId 管理员id
     * @param admin 管理员信息
     * @return 结果
     */
    @PutMapping("/admin/{adminId}")
    public R update(@PathVariable("adminId") Integer adminId, Admin admin){
        return ApiResultHandler.success(adminService.update(admin));
    }

    /**
     * 添加管理员
     *
     * @param admin 管理员信息
     * @return 结果
     */
    @PostMapping("/admin")
    public R add(Admin admin){
        return ApiResultHandler.success(adminService.add(admin));
    }

    /**
     * 更新密码
     *
     * @param adminId 管理员id
     * @param newPsw 新密码
     * @param oldPsw 旧密码
     * @return 结果
     */
    @GetMapping("/admin/resetPsw/{adminId}/{oldPsw}/{newPsw}")
    public R resetPsw(@PathVariable("adminId") Integer adminId, @PathVariable("newPsw") String newPsw, @PathVariable("oldPsw") String oldPsw) {
        return ApiResultHandler.success(adminService.resetPsw(adminId, newPsw, oldPsw));
    }
}
