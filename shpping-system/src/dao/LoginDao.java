package dao;

import domain.Users;
import orm.annotation.Select;

import java.util.List;

public interface LoginDao {

    @Select("SELECT * FROM users")
    public List<Users> selectAll();

    @Select("select * from users where username = #{username}")
    public Users selectOne(String username);
}
