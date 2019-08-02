package cn.andios.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        //1.获取添加到购物车商品的id以及商品名称
        int id= Integer.parseInt(req.getParameter("id"));
        String []names = {"Iphone7","小米","苹果","三星","华为"};
        String name = names[id];

        //2.用session存放map，map中的key/value对应货品/数量
        Map<String,Integer>map = (Map<String,Integer>)req.getSession().getAttribute("cart");
        //session里面没有存放任何东西
        if(map == null){
            map = new LinkedHashMap<String , Integer>();
            req.getSession().setAttribute("cart",map);
        }
        //3.判断map里面是否有该商品
        if(map.containsKey(name)){
            map.put(name,map.get(name)+1);
        }else{
            map.put(name,1);
        }

        //4.输出界面（跳转）
        resp.getWriter().write("<a href='product_list.jsp'><h3>继续购物</h3></a><br/>");
        resp.getWriter().write("<a href='cart.jsp'><h3>去购物车结算</h3></a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
