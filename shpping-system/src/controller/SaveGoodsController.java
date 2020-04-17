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
import java.util.ArrayList;
import java.util.HashMap;

public class SaveGoodsController extends HttpServlet {

    private GoodsService goodsService = MySpring.getBean("service.GoodsService");
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取一组被选中复选框的值
        request.setCharacterEncoding("UTF-8");
        String[] checkBox = request.getParameterValues("goodsId");
        HttpSession session = request.getSession();
        //利用一个list集合保存已购商品,相当于一辆购物车
        HashMap<Goods,Integer> shoppingCar = (HashMap<Goods,Integer>) session.getAttribute("shoppingCar");
        if(shoppingCar==null){
            shoppingCar = new HashMap<Goods,Integer>();
            session.setAttribute("shoppingCar",shoppingCar);
        }
        if(checkBox != null && checkBox.length > 0){
            for(String value: checkBox){
                Goods goods = goodsService.selectOne(value);
                Integer num = shoppingCar.get(goods);
                if(num == null){
                    num = 0;
                }
                num += 1;
                shoppingCar.put(goods,num);
            }
        }

        //根据用户不同的意向（结账/继续购物）转发给不同的页面
        if("继续购物".equals(request.getParameter("flag"))){
            request.getRequestDispatcher("showKind").forward(request,response);
        }else {

            request.getRequestDispatcher("settleAccounts").forward(request,response);
        }
    }
}
