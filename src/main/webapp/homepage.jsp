<%@ page import="dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Account" %>
<%@ page import="dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.GrantAccess" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page - Management Website</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" defer></script>
</head>
<body>
<div class="container-fluid">
    <header class="nav navbar justify-content-around">
        <a href="control-servlet/home">Home</a>
        <a href="control-servlet/log-out">Log out</a>
    </header>
    <div class="container-fluid">
        <div class="mb-3 d-flex align-items-center">
            <label class="form-label col-3">ID Account:</label>
            <input class="form-control-plaintext" value="<%= ((Account) request.getServletContext().getAttribute("account")).getId()%>">
        </div>
        <div class="mb-3 d-flex align-items-center">
            <label class="form-label col-3">Name:</label>
            <input class="form-control-plaintext" value="<%= ((Account) request.getServletContext().getAttribute("account")).getFullName()%>">
        </div>
        <div class="mb-3 d-flex align-items-center">
            <label class="form-label col-3">Email:</label>
            <input class="form-control-plaintext" value="<%= ((Account) request.getServletContext().getAttribute("account")).getEmail()%>">
        </div>
        <div class="mb-3 d-flex align-items-center">
            <label class="form-label col-3">Phone:</label>
            <input class="form-control-plaintext" value="<%= ((Account) request.getServletContext().getAttribute("account")).getPhone()%>">
        </div>
        <div class="mb-3 d-flex align-items-center">
            <label class="form-label col-3">Status:</label>
            <input class="form-control-plaintext" value="<%= ((Account) request.getServletContext().getAttribute("account")).getStatus().toString()%>">
        </div>
        <div class="mb-3 d-flex align-items-center">
            <label class="form-label col-3">Password:</label>
            <input class="form-control-plaintext" value="<%= ((Account) request.getServletContext().getAttribute("account")).getPassword()%>">
        </div>
        <form action="" method="get" class="text-center">
            <input type="submit" class="btn btn-info" value="Update Account">
        </form>
    </div>
    <%=
    (GrantAccess) request.getServletContext().getAttribute("grant-access") == null ? "" : "<div class=\"container-fluid text-center\">\n" +
            "        <h3>Management</h3>\n" +
            "    </div>\n" +
            "    <div class=\"container-fluid d-flex justify-content-around\">\n" +
            "        <a href=\"control-servlet/management/account\">Account Management</a>\n" +
            "        <a href=\"control-servlet/management/role\">Role Management</a>\n" +
            "        <a href=\"control-servlet/management/grant-access\">Grant Access Management</a>\n" +
            "        <a href=\"control-servlet/management/log\">Log Management</a>\n" +
            "    </div>"    %>
</div>
</body>
</html>