<%@ page import="dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl.AccountService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Management - Management Website</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" defer></script>
</head>
<body>
<div class="container-fluid">
    <div class="container-fluid">
        <h3 class="text-center">Add An Account</h3>
        <form action="control-servlet" method="post">
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Full Name:</label>
                <input class="form-control" name="fullName">
            </div>
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Email:</label>
                <input type="email" class="form-control" name="email">
            </div>
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Phone:</label>
                <input type="number" class="form-control" name="phone">
            </div>
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Password:</label>
                <input type="password" class="form-control" name="password">
            </div>
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Status:</label>
                <select name="status" class="form-select">
                    <option value="1">ACTIVE</option>
                    <option value="0">DE_ACTIVE</option>
                    <option value="-1">DELETE</option>
                </select>
            </div>
            <div class="container-fluid text-center">
                <input type="submit" class="btn btn-primary" name="action" value="Add Account">
            </div>
        </form>
    </div>
    <div class="container-fluid">
        <h3 class="text-center">List Account</h3>
        <table class="table table-hover">
            <thead>
            <tr>
                <td>ID Account</td>
                <td>Full Name</td>
                <td>Email</td>
                <td>Phone</td>
                <td>Status</td>
                <td></td>
                <td></td>
            </tr>
            </thead>
            <tbody>
                <%= new AccountService().findAllByHtml() %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>