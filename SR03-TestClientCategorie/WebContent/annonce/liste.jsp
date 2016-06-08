
<%@ include file="../WEB-INF/header.jsp" %>
<%@ page import="beans.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<section>
	
        <div class="row">
	        <div class="col-lg-12">
	        	<h3>Annonces</h3>					    	    
			
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				  <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="headingOne">
				      <h4 class="panel-title">
				        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
				          Liste des annonces
				        </a>
				      </h4>
				    </div>
				    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
				      <div class="panel-body">
						<table class="table table-hover" style="width:100%">
						  <tr>
						  	<th style="text-align: center;">ID</th>
						    <th style="text-align: center;">Nom</th>
						    <th style="text-align: center;">Téléphone</th>
						    <th style="text-align: center;">Catégorie</th>
						    <th style="text-align: center;">Adresse ID</th>
						    <th style="text-align: center;">Modificiation</th>
						    <th style="text-align: center;">Suppression</th>
						</tr>
					  		 <% 
					  		 
					  		ArrayList<Integer> id_list = (ArrayList<Integer>) request.getAttribute("liste_id");
							ArrayList<String> nom_list = (ArrayList<String>) request.getAttribute("liste_noms");
							ArrayList<Integer> tel_list = (ArrayList<Integer>) request.getAttribute("liste_tels");
							ArrayList<Integer> adresse_id_list = (ArrayList<Integer>) request.getAttribute("liste_adresse_id");
					       
							ArrayList<String> categorie_nom_list = (ArrayList<String>) request.getAttribute("liste_categorie_nom");
							ArrayList<Integer> categorie_id_list = (ArrayList<Integer>) request.getAttribute("liste_categorie_id");
					  	 
							for (int i = 0 ; i < id_list.size() ; i++) {
						     	int id_current = (int) id_list.get(i);
						     	String nom_current = (String)  nom_list.get(i);
						     	int tel_current = (int) tel_list.get(i);
						     	int adresse_id_current = (int) adresse_id_list.get(i);
						     	String categorie_nom_current = (String) categorie_nom_list.get(i);
						     	int categorie_id_current = (int) categorie_id_list.get(i);
					     %>
						  <tr>
						  	<td align="center"><% out.print(id_current); %></th>
						    <td align="center"><% out.print(nom_current); %></th>
						    <td align="center"><% out.print(tel_current); %></th>
						    <td align="center"><a href="/SR03-TestClientCategorie/categorie/details?categorie_id=<% out.print(categorie_id_current); %>""><% out.print(categorie_nom_current); %></a></th>
						    <td align="center"><% out.print(adresse_id_current); %></th>
						  	<td align="center"><a href="/SR03-TestClientCategorie/annonce/details?annonce_id=<% out.print(id_current); %>""><button type="button" class="btn btn-info">Détails</button></a></td>
						  	<td align="center"><a href="/SR03-TestClientCategorie/annonce/liste?annonce_id=<% out.print(id_current); %>"><button type="button" class="btn btn-warning">Supprimer</button></a></td>
						  </tr>
						  <% } %>
						</table>
				      </div>
				    </div>
				  </div>
				</div>
			</div>
		</div>
		
		<div class="well">
		<h4>Ajout d'une annonce :</h4>
		<form class="form-inline" method="POST" action ="/SR03-TestClientCategorie/annonce/liste">
	        
		        <table class="table" style=" border-top: none;">


			        <tr>
			    
				  		<td style=" border-top: none;">	
				  			<div class="form-group">
				   				<label class="sr-only">Nom</label>
				    			<p class="form-control-static">Nom : </p>
				  			</div>
				  		</td>
				  		<td style=" border-top: none;">
				  			<div class="form-group">
				    			<label for="inputName" class="sr-only"></label>
				    			<input name ="nom" type="name" class="form-control" id="inputName" placeholder="name" value="nom">
				  			</div>
				  		</td>
				  	</tr>
				
		  		</tr>
		  		<tr>
			    
				  		<td style=" border-top: none;">	
				  			<div class="form-group">
				   				<label class="sr-only">Categorie</label>
				    			<p class="form-control-static">Categorie : </p>
				  			</div>
				  		</td>
				  		<td style=" border-top: none;">
				  			<div class="form-group">
  								<select name="categorie_id" class="form-control" id="sel1">
				    	<% 		
				    	HashMap<Integer,String> categorie_array = (HashMap<Integer,String>) request.getAttribute("liste_categories");
					  	
					  	for (Map.Entry<Integer, String> entry : categorie_array.entrySet()) {
					  		int id = entry.getKey();
					  		String nom = entry.getValue();
					     %>
								  <option value="<% out.print(id);%>"><%out.print(nom); %></option>
							<%} %>  
								</select>

				  			</div>
				  		</td>
				  	</tr>
				
		  		<tr>
			    
				  		<td style=" border-top: none;">	
				  			<div class="form-group">
				   				<label class="sr-only">Telephone</label>
				    			<p class="form-control-static">Telephone : </p>
				  			</div>
				  		</td>
				  		<td style=" border-top: none;">
				  			<div class="form-group">
				    			<label for="inputName" class="sr-only"></label>
				    			<input name ="telephone" type="telephone" class="form-control" id="inputName" placeholder="telephone" value="telephone">
				  			</div>
				  		</td>
				  	</tr>
				
			  		
		  		<tr>
			    
				  		<td style=" border-top: none;">	
				  			<div class="form-group">
				   				<label class="sr-only">Numéro</label>
				    			<p class="form-control-static">Numéro : </p>
				  			</div>
				  		</td>
				  		<td style=" border-top: none;">
				  			<div class="form-group">
				    			<label for="inputName" class="sr-only"></label>
				    			<input name ="numero" type="numero" class="form-control" id="inputName" placeholder="numero" value="numero">
				  			</div>
				  		</td>
				  	</tr>
				
		  		<tr>
			    
				  		<td style=" border-top: none;">	
				  			<div class="form-group">
				   				<label class="sr-only">Rue</label>
				    			<p class="form-control-static">Rue : </p>
				  			</div>
				  		</td>
				  		<td style=" border-top: none;">
				  			<div class="form-group">
				    			<label for="inputName" class="sr-only"></label>
				    			<input name ="rue" type="rue" class="form-control" id="inputName" placeholder="rue" value="rue">
				  			</div>
				  		</td>
				  	</tr>
					
		  		<tr>
			    
				  		<td style=" border-top: none;">	
				  			<div class="form-group">
				   				<label class="sr-only">Code Postal</label>
				    			<p class="form-control-static">Code Postale : </p>
				  			</div>
				  		</td>
				  		<td style=" border-top: none;">
				  			<div class="form-group">
				    			<label for="inputName" class="sr-only"></label>
				    			<input name ="code_postale" type="code_postale" class="form-control" id="inputName" placeholder="code_postale" value="code postal">
				  			</div>
				  		</td>
				  	</tr>
					
					<tr>
			    
				  		<td style=" border-top: none;">	
				  			<div class="form-group">
				   				<label class="sr-only">Ville </label>
				    			<p class="form-control-static">Ville : </p>
				  			</div>
				  		</td>
				  		<td style=" border-top: none;">
				  			<div class="form-group">
				    			<label for="inputName" class="sr-only"></label>
				    			<input name ="ville" type="ville" class="form-control" id="inputName" placeholder="ville" value="ville">
				  			</div>
				  		</td>
				  	</tr>
		  		
		  		<tr>
			  		<td style=" border-top: none;">
			  			<button type="submit" class="btn btn-default">Valider</button>
			  		</td>
		  		</table>
			</form>
		</div>
		
		
		
		

</section>

<%@ include file="../WEB-INF/footer.jsp" %>


	