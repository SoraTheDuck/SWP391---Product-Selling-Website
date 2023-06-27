<%-- 
    Document   : Admin_manageUsers
    Created on : Jun 23, 2023, 11:00:33 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .confirm-notice {
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                background-color: #f9f9f9;
                padding: 20px;
                /*                border-radius: 5px;*/
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                /*                z-index: 9999;*/
            }

            .confirm-notice p {
                margin: 0;
                margin-bottom: 10px;
            }

            .confirm-buttons {
                text-align: right;
            }

            .confirm-buttons button {
                margin-left: 10px;
            }
        </style>
    </head>
    <body>
        <h3>Manage Users</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Email</th>                              
                    <th colspan="2" align="center"> <a href="add-user"/> Add </a> </th>                                
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ls" items="${listUser}" >
                    <tr>    
                        <td>${ls.name}</td>
                        <td>${ls.address}</td>
                        <td>${ls.email}</td>
                        <td><a href="#">Edit</a></td>
                        <td>
                            <a href="#" onclick="showConfirmation('${ls.id}', '${ls.name}')">  Delete </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
            <!-- Confirmation Notice -->
        <div id="confirmation-notice" class="confirm-notice" style="display: none;">
            <p>Are you sure to delete user?</p>
            <p><strong>User ID:</strong> <span id="user-id"></span></p>
            <p><strong>User Name:</strong> <span id="user-name"></span></p>
            <div class="confirm-buttons">
                <button onclick="deleteUser()">Yes</button>
                <button onclick="cancelDelete()">Cancel</button>
            </div>
        </div>
            
        <p><a href="Admin_page.jsp">Back to homepage</a>
        
        <script>
            var customerIdToDelete;
            // Show confirmation dialog
            function showConfirmation(id, name) {
                customerIdToDelete = id;
                document.getElementById('user-id').textContent = id;
                document.getElementById('user-name').textContent = name;
                document.getElementById('confirmation-notice').style.display = 'block';
            }

            // Delete user
            function deleteUser() {
                // Redirect to the delete action
                window.location.href = 'delete-user?id=' + customerIdToDelete;
            }
            // Cancel delete
            function cancelDelete() {
                document.getElementById('confirmation-notice').style.display = 'none';
            }
        </script>
    </body>
</html>
