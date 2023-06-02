<%-- 
    Document   : pagination
    Created on : Mar 8, 2023, 10:59:10 AM
    Author     : toden
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="text-center col-md-6 mt-5" style="margin-left: 40%">
    <nav class="text-center" aria-label="Page navigation example">
  <ul class="pagination text-center">
      <c:if test="${sessionScope.page.getCurrentPage()>1&&sessionScope.page.getCurrentPage()<sessionScope.page.getTotalPage()}">
          <li class="page-item"><a class="page-link" href="cilentPage?cp=1">First</a></li>
          <li class="page-item"><a  class="page-link" href="cilentPage?cp=${sessionScope.page.getCurrentPage()-1}">${sessionScope.page.getCurrentPage()-1}</a></li>
          <li class="page-item active"><a class="page-link" href="cilentPage?cp=${sessionScope.page.getCurrentPage()}">${sessionScope.page.getCurrentPage()}</a></li>
          <li class="page-item"><a  class="page-link" href="cilentPage?cp=${sessionScope.page.getCurrentPage()+1}">${sessionScope.page.getCurrentPage()+1}</a></li>
          <li class="page-item"><a class="page-link" href="cilentPage?cp=${sessionScope.page.getTotalPage()}">Last</a></li>
      </c:if>
      <c:if test="${sessionScope.page.getCurrentPage()==1}">
          <li class="page-item active"><a class="page-link" href="cilentPage?cp=${sessionScope.page.getCurrentPage()}">${sessionScope.page.getCurrentPage()}</a></li>
          <li class="page-item"><a  class="page-link" href="cilentPage?cp=${sessionScope.page.getCurrentPage()+1}">${sessionScope.page.getCurrentPage()+1}</a></li>
          <li class="page-item"><a class="page-link" href="cilentPage?cp=${sessionScope.page.getTotalPage()}">Last</a></li>
      </c:if>
      <c:if test="${sessionScope.page.getCurrentPage()==sessionScope.page.getTotalPage()}">
          <li class="page-item"><a class="page-link" href="cilentPage?cp=1">First</a></li>
          <li class="page-item"><a  class="page-link" href="cilentPage?cp=${sessionScope.page.getCurrentPage()-1}">${sessionScope.page.getCurrentPage()-1}</a></li>
          <li class="page-item active"><a class="page-link" href="cilentPage?cp=${sessionScope.page.getCurrentPage()}">${sessionScope.page.getCurrentPage()}</a></li>
      </c:if>
          
  </ul>
</nav>
</div>






