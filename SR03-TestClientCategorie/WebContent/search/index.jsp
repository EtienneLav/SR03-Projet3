<%@ include file="../WEB-INF/header.jsp"%>
<%@ page import="beans.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<section>
	<div class="well">
		<h4>Recherche :</h4>
		<form class="form-inline" method="POST"
			action="/SR03-TestClientCategorie/search">

			<table class="table" style="border-top: none;">

				<tr>

					<td style="border-top: none;">
						<div class="form-group">
							<label class="sr-only">Categorie</label>
							<p class="form-control-static">Categorie :</p>
						</div>
					</td>
					<td style="border-top: none;">
						<div class="form-group">
							<select name="categorie_id" class="form-control" id="sel1">
								<option selected value="0">Toutes</option>
								<%
									HashMap<Integer, String> categorie_array = (HashMap<Integer, String>) request
											.getAttribute("liste_categories");

									for (Map.Entry<Integer, String> entry : categorie_array.entrySet()) {
										int id = entry.getKey();
										String nom = entry.getValue();
								%>
								<option value="<%out.print(id);%>">
									<%
										out.print(nom);
									%>
								</option>
								<%
									}
								%>

							</select>

						</div>
					</td>
				</tr>

				<tr>
					<td style="border-top: none;">
						<div class="form-group">
							<label class="sr-only">Nom d'annonce</label>
							<p class="form-control-static">Nom d'annonce :</p>
						</div>
					</td>
					<td style="border-top: none;">
						<div class="form-group">
							<label for="inputName" class="sr-only"></label> <input
								name="name" type="name" class="form-control" id="inputName"
								placeholder="name" value="">
						</div>
					</td>
				</tr>

				<tr>
					<td style="border-top: none;">
						<div class="form-group">
							<label class="sr-only">Ville</label>
							<p class="form-control-static">Ville :</p>
						</div>
					</td>
					<td style="border-top: none;">
						<div class="form-group">
							<label for="inputVille" class="sr-only"></label> <input
								name="ville" type="name" class="form-control" id="inputVille"
								placeholder="ville" value="">
						</div>
					</td>
				</tr>

				<tr>
					<td style="border-top: none;">
						<div class="form-group">
							<label class="sr-only">Département</label>
							<p class="form-control-static">Département :</p>
						</div>
					</td>
					<td style="border-top: none;">
						<div class="form-group">
							<label for="inputDepartement" class="sr-only"></label> <input
								name="departement" type="departement" class="form-control"
								id="inputDepartement" placeholder="departement" value="">
						</div>
					</td>
				</tr>

				<tr>
					<td style="border-top: none;">
						<div class="form-group">
							<label class="sr-only">Récentes (20 dernières)</label>
							<p class="form-control-static">Récentes (20 dernières):</p>
						</div>
					</td>
					<td style="border-top: none;">
						<div class="form-group">
						
							<select name="est_recent" class="form-control" id="sel1">
								<option selected value="0">Non</option>
								<option value="1">Oui</option>
							</select>
						</div>
					</td>
				</tr>

				<tr>
					<td style="border-top: none;">
						<button type="submit" class="btn btn-default">Valider</button>
					</td>
				</tr>
			</table>
		</form>
	</div>


</section>

<%@ include file="../WEB-INF/footer.jsp"%>
