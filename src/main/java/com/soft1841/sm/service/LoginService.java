package com.soft1841.sm.service;

import cn.hutool.db.Entity;

import java.sql.SQLException;
import java.util.List;

public interface LoginService {
boolean login(String user,String password);
}
