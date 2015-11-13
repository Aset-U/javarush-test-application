<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<t:head title="Users"/>
<body>
<t:header/>
<section id="cart_items">
  <div class="container">
    <div class="breadcrumbs">
      <h3>User CRUD</h3>
    </div>
    <div class="table-responsive cart_info">
      <table class="table table-condensed">
        <thead>
        <tr class="cart_menu">
          <td class="description">id</td>
          <td class="price">Name</td>
          <td class="quantity">Age</td>
          <td class="category">Is admin</td>
          <td class="total">Created date</td>
          <td></td>
          <td></td>
        </tr>
        </thead>

        <c:forEach var="user" items="${users}" varStatus="iter">
          <tr>
            <td class="cart_description">
              <p>${user.id}</p>
            </td>
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
              <p>${user.createdDate}</p>
            </td>
            <td class="cart_delete">
              <form action="/delete" method="POST">
                <input type="hidden" name="userDeleted" value="${user.id}">
                <input type="submit"
                       name="submit"
                       value="Delete">
              </form>
            </td>
            <td class="cart_delete">
              <form action="/controller" method="POST">
                <input type="hidden" name="command" value="deleteProductCart">
                <input type="hidden" name="productDeleted" value="${product.id}">
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

<section id="do_action">
  <div class="container">
    <div class="col-sm-6">
      <div class="total_area">
        <a class="btn btn-default check_out" href="/addUser">Add new user</a>
      </div>
    </div>
  </div>
</section><!--/#do_action-->
</body>
</html>
