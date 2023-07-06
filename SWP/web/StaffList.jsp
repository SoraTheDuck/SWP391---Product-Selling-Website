<%-- 
    Document   : StaffList
    Created on : Jul 6, 2023, 10:50:08 AM
    Author     : admin
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
        <h3>Manage Staffs</h3>
        <br><h4 style="color: red">${mess}</h4>
        <table border="1">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Password</th>
                    <th>Email</th>     
                    <th>Phone</th>
                    <th>Accountant</th>
                    <th>Marketing</th>
                    <th>Order Manager</th>
                    <th>Orders Processing</th>
                    <th>Admin ID</th>
                    <th colspan="2" align="center"> <a href="addstaff"/> Add </a> </th>                                
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ls" items="${list}" >
                    <tr>
                        <td>${ls.id}</td>
                        <td>${ls.name}</td>                                
                        <td>${ls.password}</td>
                        <td>${ls.email}</td>
                        <td>${ls.phone}</td>
                        <td>
                            <c:choose>
                                <c:when test="${ls.accountant == true}">
                                    <input type="checkbox" name="accountant" checked>
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="account">
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${ls.marketing == true}">
                                    <input type="checkbox" name="accountant" checked>
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="account">
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${ls.orderManager == true}">
                                    <input type="checkbox" name="accountant" checked>
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="account">
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${ls.ordersProcessing}</td>
                        <td>${ls.adminID}</td>
                        <td><a href="#"> Edit </a> </td>
                        <td>
                            <a href="#" onclick="showConfirmation('${ls.id}', '${ls.name}')">  Delete </a>
                        </td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Confirmation Notice -->
        <div id="confirmation-notice" class="confirm-notice" style="display: none;">
            <p>Are you sure you want to delete the following staff?</p>
            <p><strong>Staff ID:</strong> <span id="product-id"></span></p>
            <p><strong>Staff Name:</strong> <span id="product-name"></span></p>
            <div class="confirm-buttons">
                <button onclick="deleteProduct()">Yes</button>
                <button onclick="cancelDelete()">Cancel</button>
            </div>
        </div>

        <p><a href="Admin_page.jsp">Back to homepage</a>

            <script>
                var productIdToDelete;

                // Show confirmation dialog
                function showConfirmation(id, name) {
                    productIdToDelete = id;
                    document.getElementById('product-id').textContent = id;
                    document.getElementById('product-name').textContent = name;
                    document.getElementById('confirmation-notice').style.display = 'block';
                }

                // Delete product
                function deleteProduct() {
                    // Redirect to the delete action
                    window.location.href = 'delete-product?id=' + productIdToDelete;
                }

                // Cancel delete
                function cancelDelete() {
                    document.getElementById('confirmation-notice').style.display = 'none';
                }
            </script>
    </body>
</html>

