<%@ include file="../WEB-INF/header.jsp"%>

<section>
	<div class="well">
	<% boolean already_logged = (boolean) request.getAttribute("already_logged"); %>
	<% if(already_logged == false) { %>
		<h4>Identification r�ussie :</h4>
		<div>
			Merci de vous �tre identifi� ! <br>
			Vous avez d�sormais acc�s � la gestion de l'anuaire.
			<br>
		</div>
		
		<%}
	else { %>
		<h4>Vous �tes d�j� identifi�</h4>
		<div>
			Inutile de vous indentifier deux fois .. 
			<br>
		</div>
	<% } %>
	</div>

</section>

<%@ include file="../WEB-INF/footer.jsp"%>
