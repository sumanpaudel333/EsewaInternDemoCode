package com.example.servletdemo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditUserComplete")
public class EditUserComplete extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html");
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String username = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        user user = new user();
        user.setUserName(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setId(id);
        boolean status = UserDao.editUserInDb(user);
        if (status) {
            response.sendRedirect("./ViewUser");
        } else {
            printWriter.println("Could not Update data! Please try again later");
        }
    }
}
