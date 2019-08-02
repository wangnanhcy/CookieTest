<%@ page import="java.util.Map" %>
<%@ page import = "java.nio.channels.SeekableByteChannel"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>您的购物车商品如下</h2>
    <%
        //1.先获取到map
        Map<String ,Integer> map = (Map<String, Integer>) session.getAttribute("cart");
        //2.遍历map
        if(map!=null){
            for (String key:map.keySet()) {
                int value = map.get(key);
    %>
        <h3>名称：<%=key%>数量：<%=value%></h3><br>
    <%        }
        }
        %>
    <a href="ClearCartServlet"><h4>清空购物车</h4></a>
</body>
</html>
