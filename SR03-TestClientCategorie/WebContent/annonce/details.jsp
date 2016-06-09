
<%@ include file="../WEB-INF/header.jsp" %>
<%@ page import="beans.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<section>
	
    
<% 
	int annonce_id = (int) request.getAttribute("annonce_id");
	String annonce_nom = (String) request.getAttribute("annonce_nom"); 
	int annonce_telephone = (int) request.getAttribute("annonce_telephone");
	int adresse_numero = (int) request.getAttribute("adresse_numero");
	String adresse_rue = (String) request.getAttribute("adresse_rue"); 
	int adresse_codePostal = (int) request.getAttribute("adresse_codePostal");
	String adresse_ville = (String) request.getAttribute("adresse_ville"); 
	
	int categorie_id = (int) request.getAttribute("categorie_id");
	String categorie_nom = (String) request.getAttribute("categorie_nom"); 
	

%>

<div class="well">
		<h4>Modification d'une annonce :</h4>
		<form class="form-inline" method="POST" action ="/SR03-TestClientCategorie/annonce/details">
	        
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
				    			<input name ="nom" type="name" class="form-control" id="inputName" placeholder="name" value="<% out.print(annonce_nom); %>">
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
								  <option <% if(categorie_id == id) out.print("selected"); %> value="<% out.print(id);%>"><%out.print(nom); %></option>
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
				    			<input name ="telephone" type="telephone" class="form-control" id="inputName" placeholder="telephone" value="<% out.print(annonce_telephone); %>">
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
				    			<input name ="numero" type="numero" class="form-control" id="inputName" placeholder="numero" value="<% out.print(adresse_numero); %>">
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
				    			<input name ="rue" type="rue" class="form-control" id="inputName" placeholder="rue" value="<% out.print(adresse_rue); %>">
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
				    			<input name ="code_postale" type="code_postale" class="form-control" id="inputName" placeholder="code_postale" value="<% out.print(adresse_codePostal); %>">
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
				    			<input name ="ville" type="ville" class="form-control" id="inputName" placeholder="ville" value="<% out.print(adresse_ville); %>">
				  			</div>
				  		</td>
				  	</tr>
		  		
		  			<input name ="annonce_id" type="hidden" class="form-control" id="inputId" placeholder="<% out.print(annonce_id); %>" value="<% out.print(annonce_id); %>">
		  		<tr>
			  		<td style=" border-top: none;">
			  			<button type="submit" class="btn btn-default">Valider</button>
			  		</td>
		  		</table>
			</form>
		</div>
		
<button type="button" class="btn btn-success"><a href="/SR03-TestClientCategorie/categorie/liste">Liste des annonces</a></button>

		

</section>

<%@ include file="../WEB-INF/footer.jsp" %>
	