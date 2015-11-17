<%@ page language="java" contentType="text/html; charset=utf8"  pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<t:head title="Add new todo item"/>
<body>
<t:header/>
<div class="container">
  <div class="row">
    <table class="table table-condensed">
      <form:form method="post" action="addItem" commandName="todoItem">

        <tr>
          <td>Title :</td>
          <td><form:input path="title" /></td>
        </tr>
        <tr>
          <td>Time (dd.MM.yyyy HH:mm) :</td>
          <td><form:input path="time" /></td>
        </tr>
        <tr>
          <td>Location :</td>
          <td>
            <form:input path="location"/>
          </td>
        </tr>
        <tr>
          <td>Status </td>
          <td>
            &nbsp;&nbsp;&nbsp
            <input type="radio" name="status" value="PERFORMED"> Performed
            &nbsp;&nbsp;&nbsp
            <input type="radio" name="status" value="NOT_DONE"> Not done
          </td>
        </tr>
        <tr>
          <td>Category :</td>
          <td>
            <menu>
            <form:select path="category">
              <c:forEach var="category" items="${categories}" varStatus="iter">
                <form:option name="category" value="${category.id}">${category.name}</form:option>
              </c:forEach>
            </form:select>
          </menu>
          </td>
        </tr>
        <tr>
          <td>Description :</td>
          <td>
            <form:textarea path="description" cols="40" rows="5" />
          </td>
        </tr>
        <tr><br></tr>
        <tr>
          <td colspan="2">
            <input type="submit" value="Add todo item"/>
          </td>
        </tr>

      </form:form>
    </table>
  </div>
</div>
</body>
</html>