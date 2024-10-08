package com.gmgx.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private String encoding;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println(config.getInitParameter("name"));
        encoding=config.getInitParameter("encoding");
        System.out.println("encoding:"+encoding);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
//        req.getAttribute("")
        req.getRequestDispatcher("main.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("student doPost");
    }
}
