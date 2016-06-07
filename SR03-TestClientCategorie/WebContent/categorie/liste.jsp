
<%@ include file="../WEB-INF/header.jsp" %>
<%@ page import="beans.*"%>
<section>
	
        <div class="row">
	        <div class="col-lg-12">
	        	<h3>Catégories</h3>					    	    
			
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				  <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="headingOne">
				      <h4 class="panel-title">
				        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
				          Liste des catégories
				        </a>
				      </h4>
				    </div>
				    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
				      <div class="panel-body">
						<table class="table table-hover" style="width:100%">
						  <tr>
						  	<th style="text-align: center;">ID</th>
						    <th style="text-align: center;">Nom</th>
						    <th style="text-align: center;">Modificiation</th>
						    <th style="text-align: center;">Suppression</th>
						</tr>
					  		 <% 
					     Categorie[] categorie_array = (Categorie[])request.getAttribute("liste_categorie");
					  	
					  	 
					  		for (int i = 0; i < categorie_array.length; i++) {
								System.out.println("ID : "+categorie_array[i].getId()+" Nom : "+categorie_array[i].getNom());
					     %>
						  <tr>
						  	<td align="center"><% out.print(categorie_array[i].getId()); %></th>
						    <td align="center"><% out.print(categorie_array[i].getNom()); %></th>
						  	<td align="center"><a href="/SR03-TestClientCategorie/categorie/details?categorie_id=<% out.print(categorie_array[i].getId()); %>""><button type="button" class="btn btn-info">Détails</button></a></td>
						  	<td align="center"><a href="/SR03-TestClientCategorie/categorie/liste?categorie_id=<% out.print(categorie_array[i].getId()); %>"><button type="button" class="btn btn-warning">Supprimer</button></a></td>
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
		<h4>Ajout d'une catégorie :</h4>
		<form class="form-inline" method="POST" action ="/SR03-TestClientCategorie/categorie/liste">
	        
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
				    			<input name ="name" type="name" class="form-control" id="inputName" placeholder="name" value="">
				  			</div>
				  		</td>
				  	</tr>
					<tr>
			  		<td style=" border-top: none;">
			  			<button type="submit" class="btn btn-default">Valider</button>
			  		</td>
		  		</tr>
		  		</table>
			</form>
		</div>
		
		
		
		

</section>

<%@ include file="../WEB-INF/footer.jsp" %>


	