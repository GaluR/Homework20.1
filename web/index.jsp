<%--
  Created by IntelliJ IDEA.
  User: galur
  Date: 09.09.2019
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Przelicznik</title>
  </head>
  <body>
  <h1>Przelicznik metryczny</h1>
  <form action="/przelicznik" method="post">
    <input type="number" name="meter" placeholder="metry"><br/>
    <input type="number" name="centymeter" placeholder="centymetry"><br/>
    <input type="number" name="milimeter" placeholder="milimetry"><br/>
    <input type="submit" value="Przelicz"><br/>
  </form>
  <h1>Przelicznik wag</h1>
  <form action="/przelicznik" method="post">
    <input type="text" name="kilogram" placeholder="kilogramy"><br/>
    <input type="text" name="gram" placeholder="gramy"><br/>
    <input type="text" name="miligram" placeholder="miligramy"><br/>
    <input type="submit" value="Przelicz">
  </form>
  </body>
</html>
