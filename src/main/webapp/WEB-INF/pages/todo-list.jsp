<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>


<html>
<t:head title="TODO List"/>
<body>
<t:header/>
<section>
  <div class="container">
    <div class="col-sm-4">
      <div class="total_area">
        <a class="btn btn-default check_out" href="/list/performed">PERFORMED</a>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="total_area">
        <a class="btn btn-default check_out" href="/list/notDone">NOT DONE</a>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="total_area">
        <a class="btn btn-default check_out" href="/list/all"> ALL </a>
      </div>
    </div>
  </div>
  <br><br>
</section>
  <section id="cart_items">

    <div class="container">
      <div class="breadcrumbs">
        <h3>TODO List</h3>
        <br>
      </div>
      <div class="table-responsive cart_info">

        <table class="table table-condensed">
          <thead>
          <tr class="cart_menu">
            <td class="description">№</td>
            <td class="price">Title</td>
            <td class="quantity">Time</td>
            <td class="category">Location</td>
            <td class="total">Description</td>
            <td></td>
            <td></td>
          </tr>
          </thead>

          <c:forEach var="item" items="${todoList}" varStatus="itr">
            <tr>
              <td class="cart_description">${offset + itr.index +1 }</td>
              <td class="cart_price">
                <p>${item.title}</p>
              </td>
              <td class="cart_quantity">
                <fmt:parseDate value="${item.time}" var="dateObject"
                                                        pattern="yyyy-MM-dd HH:mm" />
                <p><fmt:formatDate value="${dateObject}" pattern="dd.MM.yyyy" /></p>
                <p><fmt:formatDate value="${dateObject }" pattern="HH:mm" /></p>
              </td>
              <td class="cart_category">
                <p>${item.location}</p>
              </td>
              <td class="cart_total">
                <p>${item.description}</p>
              </td>
              <td>
                <a class="btn btn-default check_out" href="/list/delete"> delete </a>
              </td>
              <td>
                <a class="btn btn-default check_out" href="/list/edit"> edit </a>
              </td>
            </tr>
          </c:forEach>

        </table>
      </div>
    </div>

  </section>

<section>

  <div class="container">
    <div class="col-sm-4">
      <div class="total_area">
        <a class="btn btn-default check_out" href="/list/addItem">Add new todo item</a>
      </div>
    </div>
  </div>
  <br><br>
</section>

  <div class="container">

    <tag:paginate max="15" offset="${offset}" count="${count}"
                  uri="/user-crud" next="&raquo;" previous="&laquo;" />
  </div>


</body>
</html>
