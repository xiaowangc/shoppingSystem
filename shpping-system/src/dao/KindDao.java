package dao;

import domain.Kind;
import orm.annotation.Select;

import java.util.List;

public interface KindDao {
    //查询所有商品种类
    @Select("select * from kind")
    public List<Kind> selectAll();
}
