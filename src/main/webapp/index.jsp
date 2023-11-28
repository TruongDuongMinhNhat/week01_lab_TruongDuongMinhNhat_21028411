<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Management Website</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" defer></script>
</head>
<body>
<div class="container-fluid">
    <h3 class="text-center">Login Website</h3>
    <form action="control-servlet" method="post">
        <div class="mb-3 text-danger text-center">
            <p><%= request.getServletContext().getAttribute("loginFailed") == null ? "" : request.getServletContext().getAttribute("loginFailed") %></p>
        </div>
        <div class="mb-3">
            <label class="form-label">Email:</label>
            <input type="email" name="email" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Password:</label>
            <input type="password" name="password" class="form-control" required>
        </div>
        <div class="mb-3 text-center">
            <input type="submit" class="btn btn-primary" name="action" value="Login">
        </div>
    </form>
</div>
</body>
</html>