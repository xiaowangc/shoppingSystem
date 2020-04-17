package controller;

import service.RegisterService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {

    private RegisterService registerService = MySpring.getBean("service.RegisterService");
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String balance = request.getParameter("balance");
        registerService.registerOne(name,password,balance);
        response.sendRedirect("homePage.jsp");
    }
}
