<%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 19-04-2024
  Time: 03:43 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
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
<div id="myBankSlide" class="carousel slide" data-bs-ride="carousel">
    <!-- indicators -->
    <div class="carousel-indicators bg-danger">
        <button type="button" data-bs-target="#myBankSlide" data-bs-slide-to="0" class="active"></button>
        <button type="button" data-bs-target="#myBankSlide" data-bs-slide-to="1"></button>
        <button type="button" data-bs-target="#myBankSlide" data-bs-slide-to="2"></button>
        <button type="button" data-bs-target="#myBankSlide" data-bs-slide-to="3"></button>
    </div>
    <!-- inner items -->
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img style="height: 700px;" class="d-block w-100" src="items/management.png" />
        </div>
        <div class="carousel-item">
            <img style="height: 700px;" class="d-block w-100" src="items/update.png" />
        </div>
        <div class="carousel-item">
            <img style="height: 700px;" class="d-block w-100" src="items/transaction.png" />
        </div>
        <div class="carousel-item">
            <img style="height: 700px;" class="d-block w-100" src="items/operations.png" />
            <div class="carousel-caption">
                <p class="text-danger">Operations such as Transfer, Withdraw and Deposit</p>
                <a class="btn btn-outline-danger" href="https://github.com/razzaksr/DLTE-Java-Full-Stack-Development-Razak-Mohamed-2024/tree/master/DLTE-Java/DLTE-Java-MyBankCreditCard-ConsoleApp">
                    <h3>github <span class="bi bi-github"></span></h3>
                </a>
            </div>
        </div>
    </div>
    <!-- Controls -->
    <button class="carousel-control-prev" type="button" data-bs-target="#myBankSlide" data-bs-slide="prev">
        <span class="carousel-control-prev-icon bg-danger" aria-hidden="true"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#myBankSlide" data-bs-slide="next">
        <span class="carousel-control-next-icon bg-danger"></span>
    </button>
</div>
<% }
else {
    response.sendRedirect("index.jsp");
}%>
</body>
</html>
