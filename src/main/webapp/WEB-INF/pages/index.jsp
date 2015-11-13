
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<t:head title="Home"/>
<body>
<t:header/>
<div class="col-sm-3">
    <div class="left-sidebar">
        </div>
    </div>
<section>

    <div class="col-sm-6">
        <div class="col-sm-4">
            <div class="product-image-wrapper">
                <div class="single-products">
                    <div class="productinfo text-center">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="product-image-wrapper">
                <div class="single-products">
                    <div class="productinfo text-center">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="product-image-wrapper">
                <div class="single-products">
                    <div class="productinfo text-center">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="product-image-wrapper">
                <div class="single-products">
                    <div class="productinfo text-center">
                        <a href=" <c:url value="/users"></c:url>">
                            <h4><c:out value="User CRUD"/></h4>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="product-image-wrapper">
                <div class="single-products">
                    <div class="productinfo text-center">
                        <a href=" <c:url value="/list">
                            </c:url>">
                            <h4><c:out value="TO DO List"/></h4>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        </div>

</section>

</body>
</html>