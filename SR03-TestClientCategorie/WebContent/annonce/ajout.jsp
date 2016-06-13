
<%@ include file="../WEB-INF/header.jsp"%>
<%@ page import="beans.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<section>

	

	<div class="well">
		<h4>Ajout d'une annonce :</h4>
		<form class="form-inline" method="POST"
			action="/SR03-TestClientCategorie/ajout">

			<table class="table" style="border-top: none;">


				<tr>

					<td style="border-top: none;">
						<div class="form-group">
							<label class="sr-only">Nom</label>
							<p class="form-control-static">Nom :</p>
						</div>
					</td>
					<td style="border-top: none;">
						<div class="form-group">
							<label for="inputName" class="sr-only"></label> <input name="nom"
								type="name" class="form-control" id="inputName"
								placeholder="name" value="nom">
						</div>
					</td>
				</tr>

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
							<label class="sr-only">Telephone</label>
							<p class="form-control-static">Telephone :</p>
						</div>
					</td>
					<td style="border-top: none;">
						<div class="form-group">
							<label for="inputName" class="sr-only"></label> <input
								name="telephone" type="telephone" class="form-control"
								id="inputName" placeholder="telephone" value="telephone">
						</div>
					</td>
				</tr>


				<tr>

					<td style="border-top: none;">
						<div class="form-group">
							<label class="sr-only">Numéro</label>
							<p class="form-control-static">Numéro :</p>
						</div>
					</td>
					<td style="border-top: none;">
						<div class="form-group">
							<label for="inputName" class="sr-only"></label> <input
								name="numero" type="numero" class="form-control" id="inputName"
								placeholder="numero" value="numero">
						</div>
					</td>
				</tr>

				<tr>

					<td style="border-top: none;">
						<div class="form-group">
							<label class="sr-only">Rue</label>
							<p class="form-control-static">Rue :</p>
						</div>
					</td>
					<td style="border-top: none;">
						<div class="form-group">
							<label for="inputName" class="sr-only"></label> <input name="rue"
								type="rue" class="form-control" id="inputName" placeholder="rue"
								value="rue">
						</div>
					</td>
				</tr>

				<tr>

					<td style="border-top: none;">
						<div class="form-group">
							<label class="sr-only">Code Postal</label>
							<p class="form-control-static">Code Postale :</p>
						</div>
					</td>
					<td style="border-top: none;">
						<div class="form-group">
							<label for="inputName" class="sr-only"></label> <input
								name="code_postal" type="code_postal" class="form-control"
								id="inputName" placeholder="code_postal" value="code postal">
						</div>
					</td>
				</tr>

				<tr>

					<td style="border-top: none;">
						<div class="form-group">
							<label class="sr-only">Ville </label>
							<p class="form-control-static">Ville :</p>
						</div>
					</td>
					<td style="border-top: none;">
						<div class="form-group">
							<label for="inputName" class="sr-only"></label> <input
								name="ville" type="ville" class="form-control" id="inputName"
								placeholder="ville" value="ville">
						</div>
					</td>
				</tr>

				<tr>
					<td style="border-top: none;">
						<button type="submit" class="btn btn-default">Valider</button>
					</td>
			</table>
		</form>
	</div>





</section>

<%@ include file="../WEB-INF/footer.jsp"%>


