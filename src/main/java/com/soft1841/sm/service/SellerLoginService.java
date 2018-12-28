package com.soft1841.sm.service;

import com.soft1841.sm.entity.Seller;

/**
 * author By Ytker
 */
public interface SellerLoginService {
    /**
     * 定义布尔值返回登陆类型
     *
     * @param work_id
     * @param password
     * @return
     */
    boolean login(String work_id, String password);

    /**
     * 查询密码
     *
     * @param password
     * @return
     */
    boolean updatePasswd(String password);

    void updatePassword(Seller seller);
}
