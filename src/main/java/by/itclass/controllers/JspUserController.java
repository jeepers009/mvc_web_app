package by.itclass.controllers;

import by.itclass.model.db.DbInMemory;
import by.itclass.model.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "jspUserController", urlPatterns = "/jspSearch")
public class JspUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        User user = DbInMemory.findUserByName(name);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user.jsp");
        if (user != null){
            req.setAttribute("user", user);
        }else {
            String message = "User with name" + name + " is not found";
            req.setAttribute("message",message);
        }
        requestDispatcher.forward(req,resp);
    }
}
