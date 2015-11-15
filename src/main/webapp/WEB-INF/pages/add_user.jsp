<%@ page language="java" contentType="text/html; charset=utf8"  pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<t:head title="Add new user"/>
<body>
<t:header/>
<div class="container">
  <div class="row">

      <form:form method="post" action="addUser" commandName="user">

        <table class="cart_menu">
          <tr>
            <td>Name :</td>
            <td><form:input path="name" /></td>
          </tr>
          <tr>
            <td>Age :</td>
            <td><form:input path="age" /></td>
          </tr>
          <tr>
            <td>Is Admin :</td>
            <td>
              &nbsp;&nbsp;&nbsp
              <input type="radio" name="isAdmin" value="yes"> Yes
              &nbsp;&nbsp;&nbsp
              <input type="radio" name="isAdmin" value="no"> No
            </td>
          </tr>
          <tr><Br></tr>
          <tr>
            <td colspan="2">
              <input type="submit" value="Add User"/>
            </td>
          </tr>
        </table>

      </form:form>

  </div>
</div>
</body>
</html>