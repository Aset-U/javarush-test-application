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
      <form:form method="post" action="/editItem" commandName="itemEdit">
        <input type="hidden" name="OldItemId" value="${itemEdit.id}">
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
            <c:choose>
              <c:when test="${itemEdit.status == 'PERFORMED'}">
                &nbsp;&nbsp;&nbsp
                <input type="radio" name="status" value="PERFORMED" checked> Performed
                &nbsp;&nbsp;&nbsp
                <input type="radio" name="status" value="NOT_DONE"> Not done
              </c:when>
              <c:otherwise>
                &nbsp;&nbsp;&nbsp
                <input type="radio" name="status" value="PERFORMED" > Performed
                &nbsp;&nbsp;&nbsp
                <input type="radio" name="status" value="NOT_DONE" checked> Not done
              </c:otherwise>
            </c:choose>
          </td>
        </tr>
        <tr>
          <td>Category :</td>
          <td>
            <menu>
              <form:select path="category">
                <c:forEach var="category" items="${categories}" varStatus="iter">
                  <option name="category" value="${category.id}" ${itemEdit.category.name == category.name ? 'selected="selected"' : ''} >${category.name}</option>
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
            <input type="submit" value="Update todo item"/>
          </td>
        </tr>

      </form:form>
    </table>
  </div>
</div>
</body>
</html>