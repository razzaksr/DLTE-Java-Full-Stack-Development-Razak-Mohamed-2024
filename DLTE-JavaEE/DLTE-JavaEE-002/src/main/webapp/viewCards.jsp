<%@ page import="java.util.List" %>
<%@ page import="app.mybank.entity.CreditCard" %><%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 19-04-2024
  Time: 11:54 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>View Credit cards</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
    <%
        List<CreditCard> cards =(List<CreditCard>) request.getAttribute("myCards");
        pageContext.setAttribute("myData",cards,PageContext.APPLICATION_SCOPE);
    %>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-4 col-md-8 col-12 table-responsive p-5 shadow-lg">
                <table class="table table-striped text-nowrap">
                    <thead>
                        <tr>
                            <th>Credit card number</th><th>Credit card holder</th>
                            <th>Credit card limit</th><th>Credit card available</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%for(CreditCard each:cards){%>
                            <tr>
                                <td><%out.print(each.getCardNumber());%></td>
                                <td><%out.print(each.getCardHolder());%></td>
                                <td><%out.print(each.getCardLimit());%></td>
                                <td><%out.print(each.getCardAvailable());%></td>
                            </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <a href="mockCards.jsp">Mock cards</a>
</body>
</html>
