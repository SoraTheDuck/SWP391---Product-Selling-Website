<%-- 
    Document   : Admin_orders
    Created on : Jun 26, 2023, 4:06:26 AM
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
        <h3>Manage Oders</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Order Date</th>
                    <th>Total Money</th>
                    <th>Buyer</th>     
                    <th>Saler</th> 
                    <th> Action </th>                                
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ls" items="${listOrd}" >
                    <tr>
                        <td>${ls.ordId}</td>                                
                        <td>${ls.date}</td>
                        <td>${ls.total}</td>
                        <td>${ls.cusId}</td>
                        <td>${ls.staffId}</td>
                        <td>
                            <a href="#" onclick="showConfirmation(${ls.ordId})">  Delete </a>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

        <!-- Confirmation Notice -->
        <div id="confirmation-notice" class="confirm-notice" style="display: none;">
            <p>Are you sure to delete the order?</p>
            <p><strong>Order ID:</strong> <span id="order-id"></span></p>
            <div class="confirm-buttons">
                <button onclick="deleteOrder()">Yes</button>
                <button onclick="cancelDelete()">Cancel</button>
            </div>
        </div>

        <p><a href="Admin_page.jsp">Back to homepage</a>
            
        <script>
            var orderIdToDelete;
            
            // Show confirmation dialog
            function showConfirmation(ordId) {
                orderIdToDelete = ordId;
                document.getElementById('order-id').textContent = ordId;
                document.getElementById('confirmation-notice').style.display = 'block';
            }
            
            // Delete order
            function deleteOrder() {
                // Redirect to the delete action
                window.location.href = 'delete-order?ordId=' + orderIdToDelete;
            }
            
            // Cancel delete
            function cancelDelete() {
                document.getElementById('confirmation-notice').style.display = 'none';
            }
        </script>
    </body>
</html>
