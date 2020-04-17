package dao;

import domain.Users;
import orm.annotation.Insert;

public interface UserDao {

    @Insert("insert into users values(#{username},#{password},#{balance})")
    public void insertOne(Users users);


}
