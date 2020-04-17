package service;

import dao.GoodsDao;
import domain.Goods;
import orm.SqlSession;

import java.util.List;

public class GoodsService {

    private GoodsDao goodsDao = (GoodsDao)new SqlSession().getMapping(GoodsDao.class);
    //通过kindId找到同个种类的商品
    public List<Goods> selectGoods(String kindId){
        return goodsDao.selectOneGoods(kindId);
    }
    //通过商品编号找到该商品
    public Goods selectOne(String goodsId){
        return goodsDao.selectGoods(goodsId);
    }
}
