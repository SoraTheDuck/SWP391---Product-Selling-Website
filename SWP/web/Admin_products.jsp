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
        <h3>Manage Products</h3>
        <br><h4 style="color: red">${mess}</h4>
        <table border="1">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Image</th>
                    <th>Name</th>
                    <th>Price</th>     
                    <th>Quantity</th> 
                    <th colspan="2" align="center"> <a href="add-product"/> Add </a> </th>                                
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ls" items="${listPro}" >
                    <tr>
                        <td>${ls.id}</td>                                
                        <td>${ls.image}</td>
                        <td>${ls.name}</td>
                        <td>${ls.price}</td>
                        <td>${ls.quantity}</td>
                        <td><a href="editproduct?id=${ls.id}"> Edit </a> </td>
                        <td>
                            <a href="#" onclick="showConfirmation('${ls.id}', '${ls.name}')">  Delete </a>
                        </td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <!-- Confirmation Notice -->
        <div id="confirmation-notice" class="confirm-notice" style="display: none;">
            <p>Are you sure you want to delete the following product?</p>
            <p><strong>Product ID:</strong> <span id="product-id"></span></p>
            <p><strong>Product Name:</strong> <span id="product-name"></span></p>
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
