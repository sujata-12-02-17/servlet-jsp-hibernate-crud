<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="customer/update" method="post">
<input type="text" name="id" value="ID-..." onclick="this.value=''"/><br/>
<input type="text" name="fName" value="First-Name..." onclick="this.value=''"/><br/>
<input type="text" name="fName" value="LaST-Name..." onclick="this.value=''"/><br/>
<input type="text" name="email"  value="Email ID..." onclick="this.value=''"/><br/>
<input type="submit" value="Update"/>
</form>
</form>
</body>
</html>