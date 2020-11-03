
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="customer/register" method="post">
First Name:<input type="text" name="fName" value="First-Name..." onclick="this.value=''"/><br/>
Last Name:<input type="text" name="lName" value="Last-Name..." onclick="this.value=''"/><br/>
    Email:<input type="text" name="email"  value="Email ID..." onclick="this.value=''"/><br/>
<input type="submit" value="register"/>

<a href="DisplayCustomer.jsp">Display</a>|

</form>
</body>
</html>
