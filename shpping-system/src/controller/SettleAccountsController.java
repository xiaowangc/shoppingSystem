package controller;

import domain.Goods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SettleAccountsController extends HttpServlet {
    //结账
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<Goods,Integer> goodsMap = (HashMap<Goods, Integer>) session.getAttribute("shoppingCar");
        //遍历购物车，计算总价
        Float payment = 0F;
        Set<Goods> goodsSet = goodsMap.keySet();
        Iterator<Goods> it = goodsSet.iterator();
        while(it.hasNext()){
            Goods goods = it.next();
            Integer num = goodsMap.get(goods);
            payment += goods.getPrice() * num;
        }
        request.setAttribute("payment",payment);
        request.getRequestDispatcher("settleAccounts.jsp").forward(request,response);
    }
}
