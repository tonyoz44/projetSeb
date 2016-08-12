<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>


<jsp:useBean id="clients" scope="request" type="java.util.List <com.domaine.Client>" />

<table border="1">
	<thead>
		<tr>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Adresse</th>
			<th>Poste</th>
		</tr>
	</thead>
	<tbody>

		<%
			java.util.Iterator<com.domaine.Client> l = clients.iterator();

			while (l.hasNext()) {
				com.domaine.Client client = (com.domaine.Client) l.next();
		%>

		<tr>
			<td><%=client.getNom()%></td>
			<td><%=client.getPrenom()%></td>
			<td><%=client.getAdresse()%></td>
			<td><%=client.getPoste()%></td>
		</tr>
		<%
			}
		%>

	</tbody>
</table>



</body>
</html>