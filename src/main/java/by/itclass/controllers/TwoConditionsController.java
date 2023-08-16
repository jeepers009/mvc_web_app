package by.itclass.controllers;

import by.itclass.model.entities.User;
import by.itclass.model.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "twoConditionsController", urlPatterns = "/criteria")
public class TwoConditionsController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        List<User> users = userService.getUsersByCriteria(parameterMap);
        if (!users.isEmpty()) {
            req.setAttribute("users", users);
        } else {
            req.setAttribute("message", "Users is not found");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/users.jsp");
        requestDispatcher.forward(req, resp);

    }
}
