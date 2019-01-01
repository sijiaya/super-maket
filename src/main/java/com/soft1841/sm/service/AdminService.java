package com.soft1841.sm.service;

import com.soft1841.sm.entity.Admin;
import com.soft1841.sm.entity.Goods;

import java.util.List;

public interface AdminService {
    /**
     * 查询所有管理员
     * @return
     */
    List<Admin> getAllAdmins();
    Admin getAdminByJob_ID(Long jobId);

    /**
     *
     * @param job_id
     * @param password
     * @return
     */
    boolean login(long job_id,String password);
    /**
     *
     * @param address
     * @return
     */
    int countByAddress(String address);
}
