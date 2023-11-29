<%@ page import="dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Role" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Role - Management Website</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" defer></script>
</head>
<body>
<div class="container-fluid">
    <header class="nav navbar justify-content-around">
        <a href="${pageContext.request.contextPath}/homepage.jsp">Home</a>
        <a href="control-servlet/log-out">Log out</a>
    </header>
    <div class="container-fluid">
        <h3 class="text-center">Update Role</h3>
        <form action="" method="post">
            <div class="mb-3 d-flex">
                <label class="form-label col-3">ID Account:</label>
                <input class="form-control-plaintext" name="id" value="<%= ((Role) request.getServletContext().getAttribute("role")).getId()%>" readonly>
            </div>
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Role Name:</label>
                <input class="form-control" name="name" value="<%= ((Role) request.getServletContext().getAttribute("role")).getRoleName()%>" required>
            </div>
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Role Description:</label>
                <textarea class="form-control" name="description" required>
                    <%= ((Role) request.getServletContext().getAttribute("role")).getDescription()%>
                </textarea>
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
                <input type="submit" class="btn btn-primary" value="Update Account">
            </div>
        </form>
    </div>
</div>
</body>
</html>