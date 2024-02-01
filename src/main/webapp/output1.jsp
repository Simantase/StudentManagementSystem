<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%=request.getAttribute("output1")%>
	<h1 style="color: lime;" ><u>LIST OF DETAILS</u></h1>
	<table border="3" style="color: blue;">
   <tr style="text-align: center;">
        <td>Student Id</td>
        <td>Student Name</td>
        <td>Student Marks</td>
   </tr>
   <%
       String driver="com.mysql.cj.jdbc.Driver";
       String url="jdbc:mysql://localhost:3306/student";
       String username="root";
       String password="root";
       String query="select * from Student";
       Class.forName(driver);
       Connection con=DriverManager.getConnection(url, username, password);
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery(query);
       while(rs.next())
       {
   %>
           <tr style="text-align: center;">
           <td><%=rs.getInt("sId") %></td>
           <td><%=rs.getString("sName") %></td>
           <td><%=rs.getInt("sMarks")%></td>
           </tr>
   <%
       }
   %>
   </table>
   <%
        con.close();
   %>
</body>
</html>