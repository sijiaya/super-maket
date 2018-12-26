package com.soft1841.sm.service;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getAllGoods();
}
