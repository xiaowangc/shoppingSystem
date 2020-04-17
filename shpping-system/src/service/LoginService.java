package service;

import dao.LoginDao;
import domain.Users;
import orm.SqlSession;

public class LoginService {
    private LoginDao loginDao = (LoginDao) new SqlSession().getMapping(LoginDao.class);
    //获取一个用户
    public String authentication(String username,String password){
        Users one = loginDao.selectOne(username);
        if(one != null && one.getPassword().equals(password)){
            return "Login successfully";
        }

        return "Username or password is error";
    }
}
