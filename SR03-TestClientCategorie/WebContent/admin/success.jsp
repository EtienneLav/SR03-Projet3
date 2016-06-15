<%@ include file="../WEB-INF/header.jsp"%>

<section>
	<div class="well">
	<% boolean already_logged = (boolean) request.getAttribute("already_logged"); %>
	<% if(already_logged == false) { %>
		<h4>Identification réussie :</h4>
		<div>
			Merci de vous être identifié ! <br>
			Vous avez désormais accès à la gestion de l'anuaire.
			<br>
		</div>
		
		<%}
	else { %>
		<h4>Vous êtes déjà identifié</h4>
		<div>
			Inutile de vous indentifier deux fois .. 
			<br>
		</div>
	<% } %>
	</div>

</section>

<%@ include file="../WEB-INF/footer.jsp"%>
