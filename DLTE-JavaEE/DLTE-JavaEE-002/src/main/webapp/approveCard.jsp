<%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 19-04-2024
  Time: 09:12 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <%
        String info = (String)request.getAttribute("info");
        String error = (String)request.getAttribute("error");
    %>
    <div class="container">
        <div class="row justify-content-center" style="height: 100vh">
            <% if(info!=null&&info!=""){ %>
            <h1 class="text-center text-success"><%=info%></h1>
            <%}%>
            <% if(error!=null&&error!=""){ %>
            <h1 class="text-center text-danger"><%=error%></h1>
            <%}%>
            <form action="approve" method="post" class="col-lg-4 col-md-8 col-12 p-5 rounded-5 shadow-lg align-self-center">
                <div class="form group">
                    <label >Card Number</label>
                    <input type="number" name="cardNumber" placeholder="Card number" class="form-control" />
                </div>
                <div class="row justify-content-between">
                    <div class="col-lg-6 col-12">
                        <label >Card CVV</label>
                        <input type="number" name="cardCvv" placeholder="Card cvv" class="form-control" />
                    </div>
                    <div class="col-lg-6 col-12">
                        <label >Card Expiry</label>
                        <input type="date" name="cardExpiry" placeholder="Card expiry" class="form-control" />
                    </div>
                </div>
                <div class="row justify-content-between">
                    <div class="col-lg-6 col-12">
                        <label >Card Limit</label>
                        <input type="number" name="cardLimit" placeholder="Card limit" class="form-control" />
                    </div>
                    <div class="col-lg-6 col-12">
                        <label >Card Available</label>
                        <input type="number" name="cardAvailable" placeholder="Card available" class="form-control" />
                    </div>
                </div>
                <div class="row justify-content-between">
                    <div class="col-lg-6 col-12">
                        <label >Card Usage</label>
                        <input type="number" name="cardUsage" placeholder="Card usage" class="form-control" />
                    </div>
                    <div class="col-lg-6 col-12">
                        <label >Card Status</label>
                        <select name="cardStatus" class="form-select">
                            <option>Select Status</option>
                            <option value="true">Active</option>
                            <option value="false">Blocked</option>
                        </select>
                    </div>
                </div>
                <div class="row justify-content-between">
                    <div class="col-lg-6 col-12">
                        <label >Card Holder name</label>
                        <input type="text" name="cardHolder" placeholder="Card holder name" class="form-control" />
                    </div>
                    <div class="col-lg-6 col-12">
                        <label >Card PIN</label>
                        <input type="password" name="cardPin" placeholder="Card pin" class="form-control" />
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
</body>
</html>
