package com.soft1841.sm.dao;
import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;
import java.sql.SQLException;
import java.util.List;
public class GoodsDAOTest {
    private GoodsDAO goodsDAO = DAOFactory.getGoodsDAOInstance();
    @Test
    public void selectGoods() throws SQLException {
        List<Goods> goodsList = goodsDAO.selectGoods();
        goodsList.forEach(goods -> System.out.println(goods.getName()));
    }

    @Test
    public void insertGoods() throws SQLException {
        Goods goods = new Goods();
        goods.setTypeId(1);
        goods.setName("冰箱");
        goods.setPrice(22.22);
        goods.setVip(20);
        goods.setDescription("冰箱家电测试");
        goods.setPicture("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1545470537&di=cbd7f8af34d92646f3ec820d64fa5423&src=http://img002.hc360.cn/m6/M0E/0A/EF/wKhQoVWLUkmESjdNAAAAAPoQGGo387.jpg");
        System.out.println(goodsDAO.insertGoods(goods));
    }
    @Test
    public void selectGoodsByTypeId()throws SQLException{
        List<Goods> goodsList = goodsDAO.selectGoodsByTypeId(1);
        goodsList.forEach(goods -> System.out.println(goods.getName()));

    }
    @Test
    public void selectGoodsLike() throws SQLException {
        List<Goods> goodsList = goodsDAO.selectGoodLike("苹");
        goodsList.forEach(goods -> System.out.println(goods.getName()));
    }
}