package dao;

import domain.Goods;
import orm.annotation.Select;

import java.util.List;

public interface GoodsDao {

    @Select("select * from goods where kindId = #{kindId}")
    public List<Goods> selectOneGoods(String kindId);

    @Select("select * from goods where goodsId = #{goodsId}")
    public Goods selectGoods(String goodsId);
}
