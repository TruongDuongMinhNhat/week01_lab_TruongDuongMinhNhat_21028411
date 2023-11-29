<%@ page import="dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl.LogService" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/28/2023
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log Management - Management Website</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" defer></script>
</head>
<body>
    <div class="container-fluid text-center">
        <table class="table table-hover">
            <thead>
                <tr>
                    <td>ID Log</td>
                    <td>Account</td>
                    <td>Log-in Date</td>
                    <td>Log-out Date</td>
                    <td>Note</td>
                </tr>
            </thead>
            <tbody>
                <%= new LogService().findAllByHtml() %>
            </tbody>
        </table>
    </div>
</body>
</html>
