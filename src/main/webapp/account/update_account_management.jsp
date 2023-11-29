<%@ page import="dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Account" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Account - Management Website</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" defer></script>
</head>
<body>
<div class="container-fluid">
    <div class="container-fluid">
        <h3 class="text-center">Update An Account</h3>
        <form action="" method="post">
            <div class="mb-3 d-flex">
                <label class="form-label col-3">ID Account:</label>
                <input class="form-control-plaintext" value="<%= ((Account) request.getServletContext().getAttribute("account")).getId()%>" readonly>
            </div>
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Full Name:</label>
                <input class="form-control" name="fullName" value="<%= ((Account) request.getServletContext().getAttribute("account")).getFullName()%>" required>
            </div>
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Email:</label>
                <input type="email" class="form-control" name="email" value="<%= ((Account) request.getServletContext().getAttribute("account")).getEmail()%>" required>
            </div>
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Phone:</label>
                <input type="number" class="form-control" name="phone" value="<%= ((Account) request.getServletContext().getAttribute("account")).getPhone()%>" required>
            </div>
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Password:</label>
                <input type="password" class="form-control" name="password" value="<%= ((Account) request.getServletContext().getAttribute("account")).getPassword()%>" required>
            </div>
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Status:</label>
                <select name="status" class="form-select">
                    <option value="ACTIVE">ACTIVE</option>
                    <option value="DE_ACTIVE">DE_ACTIVE</option>
                    <option value="DELETE">DELETE</option>
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