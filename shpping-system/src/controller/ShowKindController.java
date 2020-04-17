package controller;

import domain.Kind;
import service.KindService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowKindController extends HttpServlet {
    private KindService kindService = MySpring.getBean("service.KindService");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Kind> kindList = kindService.selectAllKind();
        request.setAttribute("kindList",kindList);

        request.getRequestDispatcher("showKind.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
