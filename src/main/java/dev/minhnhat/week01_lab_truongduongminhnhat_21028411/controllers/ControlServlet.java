package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.controllers;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Account;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl.AccountService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ControlServlet", value = "/control-servlet")
public class ControlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String getAction = req.getParameter("action");
        if(getAction.equalsIgnoreCase("Login")) {
            String getEmail = req.getParameter("email");
            String getPassword = req.getParameter("password");
            Account account = new AccountService().checkLogin(getEmail, getPassword);
            if(account == null) {
                req.getServletContext().setAttribute("loginFailed", "Your email or password is not correct!");
                req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            } else {
                req.getServletContext().setAttribute("accountDetail", account);
                req.getServletContext().getRequestDispatcher("/homepage.jsp").forward(req, resp);
            }
        }
    }
}
