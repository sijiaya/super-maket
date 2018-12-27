package com.soft1841.sm.service;

import com.soft1841.sm.entity.Admin;

import java.util.List;

public interface AdminService {
    /**
     * 查询所有管理员
     * @return
     */
    List<Admin> getAllAdmins();
}
