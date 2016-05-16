<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<mt:myTemplate title="Sales">
<jsp:attribute name="content">
<style>
.rcorners2 {
	border-radius: 25px;
	border: 2px solid #73AD21;
	padding: 20px;
}

.vertical-align {
	display: flex;
	align-items: center;
}
</style>
   
 <script type="text/javascript">
					$(document).ready(function() {
						$('search').quicksearch('list-group-item');
					});

	$(document).ready(function() {
		$(".add").click( function() {
			var item = $(this).parent().clone();//create a deep copy of the object
			item.find(".add").remove(); //remove add button
		 	var current = $(this).parent().data("item");
			//if the item is already in the basket
			if ($("#basket").find("[data-item='"+ current+ "']").length > 0) {
				$("#basket").find("[data-item='" + current + "']").find(".counter").html(
			//increment counter
				function(i, val) {
			        return +val + 1
			      });
			} //end if statement
			else {
			 
		$('#basket').append("<div class='list-group-item row vertical-align item' data-item='" + current + "'>"
		+ item.html()+ "<div class='counter col-md-2'>1</div></div>");
		$('#basket').append("<input type='hidden' path='product.id' name='"+ current+ "' value='"
		+ item.find(".price .number").html()+ "'>");
		}
		});
		
		});
				</script>

    
<div class="container">
<!-- Quicksearch bar  -->
<div class="row">
	<div class="input-group col-md-7">
	  <span class="input-group-addon" id="basic-addon1">Search</span>
	  <input type="text" class="form-control"
						placeholder="Enter product name .."
						aria-describedby="basic-addon1">
	</div>
</div>

<!-- Products List -->
<div class="row">
<!-- Scroll for products list -->
	<div  class="col-md-7 pre-scrollable " style="margin-bottom: 3em;">
		<!-- defining the list -->
		<div class="list-group ">	
		 <c:forEach var="product" items="${map.productList}">
		 
		 <div class="list-group-item row vertical-align item"
								data-item="${product.id}">
		 <img class="img-circle col-md-2" height="64px"
			src="http://organikerzincanbali.com/images/bal/bal5.jpg">	
		 	    <h4 id="search" class="col-md-4 title">${product.productName}</h4>
				<h6 class="col-md-3">Adet</h6>
				<h6 class="col-md-2 price">10 TL</h6>
		     <button class="col-md-2 add">Add To Basket</button>
		 </div>
		 </c:forEach>
					
		</div> <!-- End of the list -->
	</div> <!-- End products list scroll -->
	
<!-- Invoice Summary  -->
	<div class="col-md-4 col-md-offset-1 rcorners2"
					style="margin-bottom: 3em;">
					
					
	</div>
</div> <!-- End of row div -->
	

<!-- Basket  -->
	<div class="row rcorners2">
		<form:form id="wasbasket" method="post" action="saveInvoice" modelAttribute="product" >
		<div class="list-group" id="basket">
		
		
		</div>
		<input type="submit" value="SAVE"/> 
		</form:form>
	</div>
</div> <!-- end of the div container -->

</jsp:attribute>
</mt:myTemplate>
