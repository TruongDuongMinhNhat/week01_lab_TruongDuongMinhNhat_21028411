package dev.minhnhat.week01_lab_truongduongminhnhat_21028411.controllers;

import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.enums.AccountStatus;
import dev.minhnhat.week01_lab_truongduongminhnhat_21028411.enums.RoleStatus;
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
        try {
            String[] getPath = req.getPathInfo().split("/");
            String typeDirect = getPath[1], typeObject = getPath[2];
            if(typeDirect.equalsIgnoreCase("management")) {
                if(typeObject.equalsIgnoreCase("account")) {
                    //Account
                    req.getServletContext().getRequestDispatcher("/account/account_management.jsp").forward(req, resp);
                } else if(typeObject.equalsIgnoreCase("role")) {
                    //Role
                    req.getServletContext().getRequestDispatcher("/role/role_management.jsp").forward(req, resp);
                } else if(typeObject.equalsIgnoreCase("grant-access")) {
                    //Grant - Access
                    req.getServletContext().getRequestDispatcher("/grant-access/grant-access_management.jsp").forward(req, resp);
                } else if(typeObject.equalsIgnoreCase("log")){
                    //Log
                    req.getServletContext().getRequestDispatcher("/log/log_management.jsp").forward(req, resp);
                } else if(typeObject.equalsIgnoreCase("home")) {
                    //Home
                    req.getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
                } else if(typeObject.equalsIgnoreCase("log-out")) {
                    req.getServletContext().setAttribute("loginFailed", "Bạn đã đăng xuất tài khoản");
                    req.getServletContext().setAttribute("account", null);
                    req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                }
            } else if(typeDirect.equalsIgnoreCase("update")){
                if(typeObject.equalsIgnoreCase("account")) {
                    //Account
                    String getAction = req.getParameter("action");
                    long id = Long.parseLong(getAction.split(" ")[2]);
                    Account account = new AccountService().findById(id).get();
                    req.getServletContext().setAttribute("account", account);
                    req.getServletContext().getRequestDispatcher("/account/update_account_management.jsp").forward(req, resp);
                } else if(typeObject.equalsIgnoreCase("role")) {
                    //Role
                    String getAction = req.getParameter("action");
                    long id = Long.parseLong(getAction.split(" ")[2]);
                    Role role = new RoleService().findById(id).get();
                    req.getServletContext().setAttribute("role", role);
                    req.getServletContext().getRequestDispatcher("/role/update_role_management.jsp").forward(req, resp);
                } else if(typeObject.equalsIgnoreCase("grant-access")) {
                    //Grant - Access
                }
            } else {

            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
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
                    req.getServletContext().setAttribute("account", null);
                    req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                }
            }
        } else {
            try {
                String[] splitAction = getAction.split(" ");
                String typeAction = splitAction[0], objectAction = splitAction[1];
                //Add (Insert) Opreation
                if(typeAction.equalsIgnoreCase("Add")) {
                    if(objectAction.equalsIgnoreCase("Account")) {
                            String getFullName = req.getParameter("fullName");
                            String getEmail = req.getParameter("email");
                            String getPhone = req.getParameter("phone");
                            String getPassword = req.getParameter("password");
                            String getStatus = req.getParameter("status");
                            AccountStatus status = AccountStatus.getValue(Integer.parseInt(getStatus));

                        Account account = new Account(getFullName, getPassword, getEmail, getPhone, status);
                        boolean result = new AccountService().insert(account);

                        req.getServletContext().getRequestDispatcher("/account/account_management.jsp").forward(req, resp);
                    } else if(objectAction.equalsIgnoreCase("Role")) {
                        String getRoleName = req.getParameter("name");
                        String getDescription = req.getParameter("description");
                        RoleStatus status = RoleStatus.getValue(Integer.parseInt(req.getParameter("status")));

                        Role role = new Role(getRoleName, getDescription, status);
                        boolean result = new RoleService().insert(role);

                        req.getServletContext().getRequestDispatcher("/role/role_management.jsp").forward(req, resp);
                    } else {

                    }
                    //Update Operation
                } else if(typeAction.equalsIgnoreCase("Update")) {
                    if(objectAction.equalsIgnoreCase("Account")) {
                        String getFullName = req.getParameter("fullName");
                        String getEmail = req.getParameter("email");
                        String getPhone = req.getParameter("phone");
                        String getPassword = req.getParameter("password");
                        String getStatus = req.getParameter("status");
                        AccountStatus status = AccountStatus.getValue(Integer.parseInt(getStatus));

                        Account account = new AccountService().findById(Long.parseLong(req.getParameter("id"))).get();
                        account.setFullName(getFullName);
                        account.setEmail(getEmail);
                        account.setPhone(getPhone);
                        account.setPassword(getPassword);
                        account.setStatus(status);

                        boolean result = new AccountService().update(account);
                        req.getServletContext().getRequestDispatcher("/account/account_management.jsp").forward(req, resp);
                    } else if(objectAction.equalsIgnoreCase("Role")) {
                        String getRoleName = req.getParameter("name");
                        String getDescription = req.getParameter("description");
                        RoleStatus status = RoleStatus.getValue(Integer.parseInt(req.getParameter("status")));

                        Role role = new RoleService().findById(Long.parseLong(req.getParameter("id"))).get();
                        role.setRoleName(getRoleName);
                        role.setDescription(getDescription);
                        role.setStatus(status);

                        boolean result = new RoleService().update(role);
                        req.getServletContext().getRequestDispatcher("/role/role_management.jsp").forward(req, resp);
                    } else {

                    }
                    //Delete Operation
                } else {
                    if(objectAction.equalsIgnoreCase("Account")) {
                        Account account = new AccountService().findById(Long.parseLong(req.getParameter("id"))).get();
                        account.setStatus(AccountStatus.DELETE);
                        boolean result = new AccountService().update(account);
                        req.getServletContext().getRequestDispatcher("/account/account_management.jsp").forward(req, resp);
                    } else if(objectAction.equalsIgnoreCase("Role")) {
                        Role role = new RoleService().findById(Long.parseLong(req.getParameter("id"))).get();
                        role.setStatus(RoleStatus.DELETE);
                        boolean result = new RoleService().update(role);
                        req.getServletContext().getRequestDispatcher("/role/role_management.jsp").forward(req, resp);
                    } else {

                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                req.getServletContext().setAttribute("loginFailed", "There are something wrong when login!");
                req.getServletContext().setAttribute("account", null);
                req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        }
    }
}
