package com.example.servlet;

import com.example.servlet.entity.User;
import com.example.servlet.entity.mybatisUtil;
import com.example.servlet.mapper.userMapper;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

@WebServlet(value = "/login", loadOnStartup = 1)
public class loginServlet extends HttpServlet {

    SqlSessionFactory factory;
    @SneakyThrows
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //首先设置一下响应类型
        resp.setContentType("text/html;charset=UTF-8");
        //获取POST请求携带的表单数据
        Map<String, String[]> map = req.getParameterMap();
        //判断表单是否完整
        if(map.containsKey("username") && map.containsKey("password")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
//            mybatisUtil.userManage(userMapper -> {
//                User user = userMapper.getUser(username, password);
//                if (user != null) {
//                    resp.getOutputStream();
//                }
//            });
            SqlSessionFactory sql = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
            try (SqlSession sqlSession = sql.openSession(true)) {
                userMapper usermapper = sqlSession.getMapper(userMapper.class);
                User user = usermapper.getUser(username, password);
                if (user != null) {
                    resp.getWriter().write("Login !");
                } else {
                    resp.getWriter().write("Oops !");
                }
            }
            //权限校验（待完善）
        }else {
            resp.getWriter().write("错误，您的表单数据不完整！");
        }
    }
}
