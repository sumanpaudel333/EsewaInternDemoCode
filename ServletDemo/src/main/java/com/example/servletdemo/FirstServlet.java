package com.example.servletdemo;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter pw=res.getWriter();
        res.setContentType("text/html");
        pw.println("<h1>Hello World!</h1>");
        pw.close();
    }
}
