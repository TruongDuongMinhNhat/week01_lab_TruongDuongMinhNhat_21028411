<%@ page import="dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl.AccountService" %>
<%@ page import="dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Account" %>
<%@ page import="dev.minhnhat.week01_lab_truongduongminhnhat_21028411.models.Role" %>
<%@ page import="dev.minhnhat.week01_lab_truongduongminhnhat_21028411.services.impl.GrantAccessService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Grant Access - Management Website</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" >
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" defer></script>
</head>
<body>
<div class="container-fluid">
    <div class="container-fluid">
        <h3 class="text-center">Add Grant Access</h3>
        <form action="control-servlet" method="post">
            <div class="container-fluid mb-3 d-flex">
                <label class="form-label col-3">Account:</label>
                <input class="form-control" type="number" name="accountID">
            </div>
            <div class="container-fluid mb-3 d-flex">
                <label class="form-label col-3">Role:</label>
                <input class="form-control" type="number" name="roleID">
            </div>
            <div class="container-fluid mb-3 d-flex">
                <label class="form-label col-3">Note:</label>
                <textarea name="note" class="form-control"></textarea>
            </div>
            <div class="container-fluid mb-3 d-flex">
                <label class="form-label col-3">Is Grant:</label>
                <input type="checkbox" class="form-check" name="isGrant" checked>
            </div>
            <div class="container-fluid mb-3 text-center">
                <input type="submit" class="btn btn-primary" value="Add Grant">
            </div>
        </form>
    </div>
    <div class="container-fluid">
        <h3 class="text-center">List Grant Access</h3>
        <table class="table table-hover">
            <thead>
            <tr>
                <td>Account Grant</td>
                <td>Role</td>
                <td>Is Grant</td>
                <td>Note</td>
                <td></td>
                <td></td>
            </tr>
            </thead>
            <tbody>
                <%= new GrantAccessService().findAllByHtml() %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
