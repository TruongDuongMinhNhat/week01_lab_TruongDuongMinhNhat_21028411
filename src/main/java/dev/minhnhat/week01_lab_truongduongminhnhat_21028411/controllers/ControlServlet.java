package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.controllers;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Account;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.GrantAccess;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.GrantAccessID;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Role;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl.AccountService;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl.GrantAccessService;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl.RoleService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ControlServlet", value = "/control-servlet/*")
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
                try {
                    Role role = new RoleService().findByRoleName("ADMIN");
                    GrantAccess grantAccess = new GrantAccessService().findById(account, role);
                    req.getServletContext().setAttribute("grant-access", grantAccess);
                    req.getServletContext().setAttribute("account", account);
                    req.getServletContext().getRequestDispatcher("/homepage.jsp").forward(req, resp);
                } catch (Exception exception) {
                    exception.printStackTrace();
                } finally {
                    req.getServletContext().setAttribute("loginFailed", "There are something wrong when login!");
                    req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                }
            }
        }
    }
}
