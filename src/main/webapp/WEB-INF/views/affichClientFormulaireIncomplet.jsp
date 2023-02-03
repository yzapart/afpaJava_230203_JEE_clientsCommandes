<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Client"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire incomplet</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<% Client c = (Client) request.getServletContext().getAttribute("clientSession"); %>

<h2>Formulaire incomplet :</h2>

<div class="container">
		<div class="formulaire">
			<form action="AjoutClient" method="post">
				<div class="ligne">
					<span>Nom *</span>
					<%
						if (c.getNom() == "") {
							%><span><input type="text" name="nom" style="border-color: red"></span><%
					    } else {
					    	%><span><input type="text" name="nom" value="<%= c.getNom() %>"></span><%
					    }
					%>
				</div>
				<div class="ligne">
					<span>Prenom</span> 
					<%
						if (c.getPrenom() == "") {
							%><span><input type="text" name="prenom"></span><%
					    } else {
					    	%><span><input type="text" name="prenom" value="<%= c.getPrenom() %>"></span><%
					    }
					%>
				</div>
				<div class="ligne">
					<span>Adresse de livraison *</span> 
					<%
						if (c.getAdresse() == "") {
							%><span><input type="text" name="adresse" style="border-color: red"></span><%
					    } else {
					    	%><span><input type="text" name="adresse" value="<%= c.getAdresse() %>"></span><%
					    }
					%>
				</div>
				<div class="ligne">
					<span>Numéro de téléphone *</span>
					<%
						if (c.getTelephone() == "") {
							%><span><input type="text" name="telephone" style="border-color: red"></span><%
					    } else {
					    	%><span><input type="text" name="telephone" value="<%= c.getTelephone() %>"></span><%
					    }
					%> 
				</div>
				<div class="ligne">
					<span>Adresse email</span>
					<%
						if (c.getEmail() == "") {
							%><span><input type="text" name="email"></span><%
					    } else {
					    	%><span><input type="text" name="email" value="<%= c.getEmail() %>"></span><%
					    }
					%> 
				</div>
				<div class="send">
				<span>
					<input type="hidden" name="etape" value="premiereSaisie">
					<input type="submit" value="Valider">
				</span>
				</div>
			</form>
		</div>
	</div>
</body>
</html>