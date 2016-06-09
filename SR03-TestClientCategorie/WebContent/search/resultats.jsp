
<%@ include file="../WEB-INF/header.jsp"%>
<%@ page import="beans.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<section>
	<%
		ArrayList<Integer> id_list = (ArrayList<Integer>) request.getAttribute("liste_id");
		ArrayList<String> nom_list = (ArrayList<String>) request.getAttribute("liste_noms");
		ArrayList<Integer> tel_list = (ArrayList<Integer>) request.getAttribute("liste_tels");
		ArrayList<Integer> adresse_id_list = (ArrayList<Integer>) request.getAttribute("liste_adresse_id");

		ArrayList<String> categorie_nom_list = (ArrayList<String>) request.getAttribute("liste_categorie_nom");
		ArrayList<Integer> categorie_id_list = (ArrayList<Integer>) request.getAttribute("liste_categorie_id");
		
		ArrayList<Integer> adresse_numero_list = (ArrayList<Integer>) request.getAttribute("liste_adresse_numero");
		ArrayList<String> adresse_rue_list = (ArrayList<String>) request.getAttribute("liste_adresse_rue");
		ArrayList<Integer> adresse_code_postal_list = (ArrayList<Integer>) request.getAttribute("liste_adresse_code_postal");
		ArrayList<String> adresse_ville_list = (ArrayList<String>) request.getAttribute("liste_adresse_ville");
	%>

	
	<div class="row">
		<div class="col-lg-12">
			<h3>Résultats de recherche</h3>
			<% if(id_list.size() > 0) { %>
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="headingOne">
						<h4 class="panel-title">
							<a role="button" data-toggle="collapse" data-parent="#accordion"
								href="#collapseOne" aria-expanded="false"
								aria-controls="collapseOne"> Voici les annonces
								correspondant à votre recherche. </a>
						</h4>
					</div>
					<div id="collapseOne" class="panel-collapse collapse in"
						role="tabpanel" aria-labelledby="headingOne">
						<div class="panel-body">
							<table class="table table-hover" style="width: 100%">
								<tr>
									<th style="text-align: center;">ID</th>
									<th style="text-align: center;">Nom</th>
									<th style="text-align: center;">Téléphone</th>
									<th style="text-align: center;">Catégorie</th>
									<th style="text-align: center;">Adresse</th>
								</tr>
								<%
									for (int i = 0; i < id_list.size(); i++) {
										int id_current = (int) id_list.get(i);
										String nom_current = (String) nom_list.get(i);
										int tel_current = (int) tel_list.get(i);
										int adresse_id_current = (int) adresse_id_list.get(i);
										String categorie_nom_current = (String) categorie_nom_list.get(i);
										int categorie_id_current = (int) categorie_id_list.get(i);
										
										int adresse_numero_current = (int) adresse_numero_list.get(i);
										String categorie_rue_current = (String) adresse_rue_list.get(i);
										int adresse_code_postal_current = (int) adresse_code_postal_list.get(i);
										String categorie_ville_current = (String) adresse_ville_list.get(i);
								%>
								<tr>
									<td align="center">
										<%
											out.print(id_current);
										%>
									
									</th>
									<td align="center">
										<%
											out.print(nom_current);
										%>
									
									</th>
									<td align="center">
										<%
											out.print(tel_current);
										%>
									
									</th>
									<td align="center">
										<%
											out.print(categorie_nom_current);
										%>
									
									</th>
									<td align="center">
										<%
											out.print(adresse_numero_current+", rue "+categorie_rue_current+" "+adresse_code_postal_current+" "+categorie_ville_current);
										%>
									
									</th>
								</tr>
								<%
									}
								%>
							</table>
						</div>
					</div>
				</div>
			</div>
			<% }
	else{ %>
	<div>Aucune annonce ne correspond à votre recherche ...</div><br>
	<% }%>
		</div>
	</div>
	
	<button type="button" class="btn btn-success">
		<a href="/SR03-TestClientCategorie/search">Effectuer une nouvelle
			recherche</a>
	</button>

</section>

<%@ include file="../WEB-INF/footer.jsp"%>


