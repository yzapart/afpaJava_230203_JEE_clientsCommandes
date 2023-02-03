<%@page import="model.Client"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>affichListeClients.jsp</title>
</head>
<body>
	
	<% ArrayList<Client> liste = (ArrayList<Client>) request.getServletContext().getAttribute("listeClientsSession"); %>
	
	<h1>Liste des clients :</h1>
	
	<table border="1">
		<tr>
			<td>Nom</td>
			<td>Prénom</td>
			<td>Adresse de livraison</td>
			<td>Téléphone</td>
			<td>Email</td>
		</tr>
		<%
		for (Client client : liste) { %>
			<tr>
				<td><%= client.getNom() %></td>
				<td><%= client.getPrenom() %></td>
				<td><%= client.getAdresse() %></td>
				<td><%= client.getTelephone() %></td>
				<td><%= client.getEmail() %></td>
			</tr>
			
		<%
		}
		%>
		
	</table>



</body>
</html>