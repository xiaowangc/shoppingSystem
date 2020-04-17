package service;

import dao.UserDao;
import domain.Users;
import orm.SqlSession;

public class RegisterService {

    private UserDao userDao = (UserDao) new SqlSession().getMapping(UserDao.class);

    //注册用户
    public void registerOne(String username,String password,String balance){
        Users one = new Users();
        one.setUsername(username);
        one.setPassword(password);
        one.setBalance(Float.parseFloat(balance));
        userDao.insertOne(one);
    }

}
