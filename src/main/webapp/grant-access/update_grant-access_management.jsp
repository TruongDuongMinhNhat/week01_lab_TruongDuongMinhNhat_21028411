<%@ page import="dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Account" %>
<%@ page import="dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Role" %>
<%@ page import="dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.GrantAccess" %>
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
    <header class="nav navbar justify-content-around">
        <a href="${pageContext.request.contextPath}/homepage.jsp">Home</a>
        <a href="control-servlet/log-out">Log out</a>
    </header>
    <div class="container-fluid">
        <h3 class="text-center">Update An Account</h3>
        <form action="../../control-servlet/" method="post">
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Account:</label>
                <input class="form-control-plaintext" name="account" value="<%= ((GrantAccess) request.getServletContext().getAttribute("grant_access")).getGrantAccessID().getAccount().getId() + "-" + ((GrantAccess) request.getServletContext().getAttribute("grant_access")).getGrantAccessID().getAccount().getFullName()%>" readonly>
            </div>
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Role:</label>
                <input class="form-control-plaintext" name="role" value="<%= ((GrantAccess) request.getServletContext().getAttribute("grant_access")).getGrantAccessID().getRole().getId() + "-" + ((GrantAccess) request.getServletContext().getAttribute("grant_access")).getGrantAccessID().getRole().getRoleName() %>" readonly>
            </div>
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Is Grant:</label>
                <input type="checkbox" class="form-check" name="isGrant" checked>
            </div>
            <div class="mb-3 d-flex">
                <label class="form-label col-3">Note:</label>
                <textarea class="form-control" name="note" required>
                    <%= ((GrantAccess) request.getServletContext().getAttribute("grant_access")).getNote()%>
                </textarea>
            </div>
            <div class="container-fluid text-center">
                <input type="submit" class="btn btn-primary" name="action" value="Update Grant">
            </div>
        </form>
    </div>
</div>
</body>
</html>