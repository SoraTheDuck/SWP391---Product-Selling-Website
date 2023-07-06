<%-- 
    Document   : Admin_add-user
    Created on : Jun 25, 2023, 10:10:50 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit user</h1>
        <form action="edit-cus" method="post" id="edit-form" onsubmit="return checkChanges()">
            Id: <input value="${cus.id}" type="text" name="id" readonly />
            <br/> 
            Name: <input value="${cus.name}" type="text" name="name" />
            <br/> 
            Password: <input value="${cus.password}" type="password" name="pass" id="password-input" />
            <button type="button" id="show-password-button" onclick="showPass()">Unhide</button>
            <br/>
            Address: <input value="${cus.address}" type="text" name="address" />
            <br/>
            Email: <input value="${cus.email}" type="email" name="email" />
            <br/>
            <input type="submit" value="Update" onclick="checkFormChanges(event)"/>
            <button type="button" onclick="cancelForm()">Cancel</button>
        </form>
        <p id="change-message" style="display: none;">No changes were made.</p>
        <p><a href="list-user">Back</a></p>

        <script>
            let originalData = {
                name: "${cus.name}",
                password: "${cus.password}",
                address: "${cus.address}",
                email: "${cus.email}"
            };

            function showPass() {   //ẩn hiện pass
                const passwordInput = document.getElementById('password-input');

                if (passwordInput.type === 'password') {
                    passwordInput.type = 'text';
                    document.getElementById('show-password-button').textContent = 'Hide';
                } else {
                    passwordInput.type = 'password';
                    document.getElementById('show-password-button').textContent = 'Unhide';
                }
            }

            function cancelForm() {
                const form = document.querySelector('form');
                form.reset();
            }

            function checkChanges() {
                const formData = {
                    name: document.getElementsByName('name')[0].value,
                    password: document.getElementsByName('pass')[0].value,
                    address: document.getElementsByName('address')[0].value,
                    email: document.getElementsByName('email')[0].value
                };

                const isChanged = Object.keys(originalData).some(key => originalData[key] !== formData[key]);

                if (!isChanged) {
                    document.getElementById('change-message').style.display = 'block';
                    return false; 
                }

                return true;
            }
        </script>
    </body>


</html>
