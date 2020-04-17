package controller;

import domain.Goods;
import service.GoodsService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ShowGoodsController extends HttpServlet {

    private GoodsService goodsService = MySpring.getBean("service.GoodsService");
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kindId = request.getParameter("kindId");
        List<Goods> goodsList = goodsService.selectGoods(kindId);
        request.setAttribute("goods",goodsList);

        //用来存储被选中的商品，键为商品的编号，值为该商品对象
        request.getRequestDispatcher("showGoodsPage.jsp").forward(request,response);
    }
}
