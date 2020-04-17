package controller;

import domain.Kind;
import service.KindService;
import service.LoginService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginController extends HttpServlet {

    private LoginService loginService = new LoginService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("username");
        String password =  request.getParameter("password");
        String result = loginService.authentication(name,password);
        if("Login successfully".equals(result)){

            request.getRequestDispatcher("welcome.jsp").forward(request,response);
        }else{
            request.setAttribute("result",result);
            request.getRequestDispatcher("homePage.jsp").forward(request,response);

        }
    }
}
