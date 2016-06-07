
<%@ include file="../WEB-INF/header.jsp" %>
<%@ page import="beans.*"%>
<section>
	
        <div class="row">
	        <div class="col-lg-12">
	        	<h3>Catégorie</h3>					    	    
			
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				  <div class="panel panel-default">
				    <div class="panel-heading" role="tab" id="headingOne">
				      <h4 class="panel-title">
				        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
				          Modification d'une catégorie
				        </a>
				      </h4>
				    </div>
				    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
				      <div class="panel-body">
				      
				      <form class="form-inline" method="POST" action ="/SR03-TestClientCategorie/categorie/details">
						<table class="table table-hover" style="width:100%">
						  <tr>
						  <th>
						    <th style="text-align: center;">Nom</th>
						</tr>
					  		 <% 
					     Categorie categorie = (Categorie)request.getAttribute("categorie");
					  	%>
					  	 
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
				    				<input name ="name" type="name" class="form-control" id="inputName placeholder="<% out.print(categorie.getNom()); %>" value="<% out.print(categorie.getNom()); %>">
				  					<input name ="id" type="hidden" class="form-control" id="inputId" placeholder="<% out.print(categorie.getId()); %>" value="<% out.print(categorie.getId()); %>">
				  				</div>
				  			</td>
						</tr>
						<tr>
			  				<td style=" border-top: none;">
			  					<button type="submit" class="btn btn-default">Valider</button>
			  				</td>
		  				</tr>
						</table>
						
				      </div>
				    </div>
				  </div>
				</div>
				
			</div>
		</div>
		
		<button type="submit" class="btn btn-success"><a href="/SR03-TestClientCategorie/categorie/liste">Liste des catégories</a></button>

</section>

<%@ include file="../WEB-INF/footer.jsp" %>


	