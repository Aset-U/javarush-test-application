<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>


<html>
<t:head title="Users"/>
<body>
<t:header/>
<nav class="navbar navbar-default">
<section id="cart_items">

  <div class="container">
  <div class="breadcrumbs">
    <h3>User CRUD</h3>
    <br>
  </div>

  <form class="navbar-form navbar-static-top" role="search" action="/user-crud/search" method="post">
  <div class="form-group">
    <input type="text" class="form-control" placeholder="Search by name" name="search">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>


    <div class="table-responsive cart_info">

      <table class="table table-condensed">
        <thead>
        <tr class="cart_menu">
          <td class="description">User id</td>
          <td class="price">Name</td>
          <td class="quantity">Age</td>
          <td class="category">Is admin</td>
          <td class="total">Created date</td>
          <td></td>
          <td></td>
        </tr>
        </thead>

        <c:forEach var="user" items="${users}" varStatus="itr">
          <tr>
            <td class="cart_description">${offset + itr.index +1 }</td>
            <td class="cart_price">
              <p>${user.name}</p>
            </td>
            <td class="cart_quantity">
              <p> ${user.age}</p>
            </td>
            <td class="cart_category">
              <p>${user.admin}</p>
            </td>
            <td class="cart_total">
              <fmt:parseDate value="${user.createdDate}" var="dateObject"
                             pattern="yyyy-MM-dd HH:mm" />
              <p><fmt:formatDate value="${dateObject}" pattern="dd.MM.yyyy" /></p>
              <p><fmt:formatDate value="${dateObject }" pattern="HH:mm" /></p>
            </td>
            <td class="cart_delete">
              <form action="/delete" method="POST">
                <input type="hidden" name="userDeleted" value="${user.id}">
                <input type="submit"
                       name="submit"
                       value="Delete">
              </form>
            </td>
            <td class="form-group">
              <form action="/user-crud/edit" method="POST">
                <input type="hidden" name="userEdit" value="${user.id}">
                <input type="submit"
                       name="submit"
                       value="Edit">
              </form>
            </td>
          </tr>

        </c:forEach>

      </table>
    </div>
  </div>


</section> <!--/#cart_items-->
<section>

  <div class="container">
    <div class="col-sm-4">
    <div class="total_area">
      <a class="btn btn-default check_out" href="/addUser">Add new user</a>
    </div>
  </div>
</div>
  <br><br>
</section>

<div class="container">

  <tag:paginate max="15" offset="${offset}" count="${count}"
                uri="/user-crud" next="&raquo;" previous="&laquo;" />
</div
  </nav>

</body>
</html>
