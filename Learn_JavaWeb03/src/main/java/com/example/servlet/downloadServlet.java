package com.example.servlet;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.io.Resources;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(value = "/download")
public class downloadServlet extends HttpServlet {
    @SneakyThrows
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("Download!");
        //        resp.setContentType("image/png");
//        OutputStream outputStream = resp.getOutputStream();
//        InputStream inputStream = Resources.getResourceAsStream("header.png");
//        IOUtils.copy(inputStream, outputStream);

    }
}
