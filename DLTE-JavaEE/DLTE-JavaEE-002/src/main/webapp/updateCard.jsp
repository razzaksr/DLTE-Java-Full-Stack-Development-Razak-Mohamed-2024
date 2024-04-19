<%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 19-04-2024
  Time: 09:12 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Approve Credit card</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if(session.getAttribute("username")!=null){ %>
<nav class="navbar navbar-expand-lg" style="background:linear-gradient(90deg,white,red);">
    <div class="container-fluid">
        <!-- 1st logo/ brand -->
        <a class="navbar-brand text-danger display-6 text-uppercase" style="font-weight: bold;" href="#">MyBank</a>
        <!-- 2nd toggle a -->
        <a class="navbar-toggler bg-light" type="a" data-bs-toggle="collapse" data-bs-target="#myBankMenu">
            <span class="navbar-toggler-icon"></span>
        </a>
        <!-- 3rd Menu -->
        <div class="collapse navbar-collapse" id="myBankMenu">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <p class="text-light display-6">Hi, <%=session.getAttribute("username")%></p>
                </li>
                <li class="nav-item">
                    <a href="view" class="btn btn-outline-light rounded-5 me-2"><span class="bi bi-list-columns"></span> View</a>
                </li>
                <li class="nav-item">
                    <a href="approveCard.jsp" class="btn btn-outline-light rounded-5 me-2"><span class="bi bi-cloud-plus-fill"></span> New</a>
                </li>
                <li class="nav-item">
                    <a href="logout" class="btn btn-outline-light rounded-5 me-2"><span class="bi bi-door-open"></span> Logout</a>
                </li>
                <li>
                    <form action="viewByLimit.jsp">
                        <input type="text" name="limit" />
                        <input type="submit" value="filter">
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>

<%
    String info = (String)request.getAttribute("info");
    String error = (String)request.getAttribute("error");
%>
<%@ taglib prefix="elroy" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="rakchanya" uri="http://java.sun.com/jsp/jstl/core" %>
<elroy:setDataSource var="sanakroy" driver="oracle.jdbc.driver.OracleDriver"
                     url="jdbc:oracle:thin:@localhost:1521:xe"
                     user="system"
                     password="root"
/>
<elroy:query var="arunashira" dataSource="${sanakroy}" sql="select * from mybank_creditcard where creditcard_number=?">
    <elroy:param value="${param['number']}"/>
</elroy:query>
<rakchanya:set var="oneCard" value="${arunashira.rows[0]}" />
<div class="container">
    <div class="row justify-content-center" style="height: 100vh">
        <% if(info!=null&&info!=""){ %>
        <h1 class="text-center text-success"><%=info%></h1>
        <%}%>
        <% if(error!=null&&error!=""){ %>
        <h1 class="text-center text-danger"><%=error%></h1>
        <%}%>
        <form action="update" method="post" class="col-lg-4 col-md-8 col-12 p-5 rounded-5 shadow-lg align-self-center">
            <div class="form group">
                <label >Card Number</label>
                <input readonly value="${oneCard.creditcard_number}" type="number" name="cardNumber" placeholder="Card number" class="form-control" />
            </div>
            <div class="row justify-content-between">
                <div class="col-lg-6 col-12">
                    <label >Card CVV</label>
                    <input readonly value="${oneCard.creditcard_cvv}" type="number" name="cardCvv" placeholder="Card cvv" class="form-control" />
                </div>
                <div class="col-lg-6 col-12">
                    <label >Card Expiry</label>
                    <input readonly value="${oneCard.creditcard_expiry}" type="text" name="cardExpiry" placeholder="Card expiry" class="form-control" />
                </div>
            </div>
            <div class="row justify-content-between">
                <div class="col-lg-6 col-12">
                    <label >Card Limit</label>
                    <input value="${oneCard.creditcard_limit}" type="number" name="cardLimit" placeholder="Card limit" class="form-control" />
                </div>
                <div class="col-lg-6 col-12">
                    <label >Card Available</label>
                    <input value="${oneCard.creditcard_available}" type="number" name="cardAvailable" placeholder="Card available" class="form-control" />
                </div>
            </div>
            <div class="row justify-content-between">
                <div class="col-lg-6 col-12">
                    <label >Card Usage</label>
                    <input value="${oneCard.creditcard_usage}" type="number" name="cardUsage" placeholder="Card usage" class="form-control" />
                </div>
                <div class="col-lg-6 col-12">
                    <label >Card Status</label>
                    <input readonly value="${oneCard.creditcard_status}" type="text" name="cardStatus" class="form-control" />
                </div>
            </div>
            <div class="row justify-content-between">
                <div class="col-lg-6 col-12">
                    <label >Card Holder name</label>
                    <input readonly value="${oneCard.creditcard_holder}" type="text" name="cardHolder" placeholder="Card holder name" class="form-control" />
                </div>
                <div class="col-lg-6 col-12">
                    <label >Card PIN</label>
                    <input value="${oneCard.creditcard_pin}" type="password" name="cardPin" placeholder="Card pin" class="form-control" />
                </div>
            </div>
            <div class="row justify-content-around mt-3">
                <div class="col-2">
                    <button type="submit" class="btn btn-outline-info"><h1 class="bi bi-check-circle-fill"></h1></button>
                </div>
                <div class="col-2">
                    <button type="reset" class="btn btn-outline-secondary"><h1 class="bi bi-x-lg"></h1></button>
                </div>
            </div>
        </form>
    </div>
</div>
<% }
else {
    response.sendRedirect("index.jsp");
}%>
</body>
</html>
