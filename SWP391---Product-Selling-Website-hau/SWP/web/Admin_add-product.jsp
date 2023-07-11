<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
    </head>
    <body>
        <h1>Add Product</h1>

        <form action="add-product" method="POST" enctype="multipart/form-data">
            <p>${mess}</p>
            Id: <input type="text" name="id" placeholder="Please enter product ID" required/>
            <br/> 
            Name: <input type="text" name="name" placeholder="Please enter product name" required/>
            <br/> 
            Price: <input type="text" name="price" placeholder="Please enter product price" required/>
            <br/> 
            Image: <input type="file" name="image" accept=".png,.jpg,.webp,.jpeg,.jpe"/>
            <br/> 
            Quantity: <input type="number" name="quantity" placeholder="Please enter product quantity" required/>
            <br/> 
            Wire:
            <input type="radio" id="wired" name="wire" value="0" checked="true">
            <label for="wired">Wired</label>
            <input type="radio" id="wireless" name="wire" value="1">
            <label for="wireless">Wireless</label><br>
            <br/> 
            Description: <input type="text" name="description" placeholder="Please enter product description" required/>
            <br/> 
            Category: <select name="category">
                <c:forEach items="${categoryList}" var="o">
                    <option value="${o.getId()}">${o.getCategoryName()}</option>
                </c:forEach>
            </select>


            <input type="submit" value="Add Product"/>
        </form>
        <p><a href="Admin_page.jsp">Back to homepage</a></p>
    </body>
</html>
