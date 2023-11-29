<%@ page import="dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl.RoleService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Role Management - Management Website</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" defer></script>
</head>
<body>
<div class="container-fluid">
    <header class="nav navbar justify-content-around">
        <a href="../homepage.jsp">Home</a>
        <a href="control-servlet/log-out">Log out</a>
    </header>
    <div class="container-fluid">
        <h3 class="text-center">Add Role</h3>
        <form action="control-servlet" method="post">
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Role Name:</label>
                <input class="form-control" name="name" required>
            </div>
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Description:</label>
                <textarea class="form-control" name="description" required>

                </textarea>
            </div>
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Status:</label>
                <select name="status" class="form-select" required>
                    <option value="1">ACTIVE</option>
                    <option value="0">DE_ACTIVE</option>
                    <option value="-1">DELETE</option>
                </select>
            </div>
            <div class="container-fluid text-center">
                <input type="submit" class="btn btn-primary" name="action" value="Add Role">
            </div>
        </form>
    </div>
    <div class="container-fluid">
        <h3 class="text-center">List Roles</h3>
        <table class="table table-hover">
            <thead>
            <tr>
                <td>ID Role</td>
                <td>Role Name</td>
                <td>Role Description</td>
                <td>Status</td>
                <td></td>
                <td></td>
            </tr>
            </thead>
            <tbody>
                <%= new RoleService().findAllByHtml() %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>