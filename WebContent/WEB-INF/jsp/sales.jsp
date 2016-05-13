<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
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
    	$(document).ready(function(){
    		 $('#search').quicksearch('list-group-item h4');    		
    	});
    </script>
    
<div class="container">

<div class="row">
	<div class="input-group col-md-7">
	  <span class="input-group-addon" id="basic-addon1">Search</span>
	  <input name="search" type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
	</div>
</div>

<div class="row" >
	<div class="col-md-7 pre-scrollable " style="margin-bottom:3em;">
		<div class="list-group ">			
			<a href="#" class="list-group-item row vertical-align">
				<img class="img-circle col-md-2" height="64px"  src="http://organikerzincanbali.com/images/bal/bal5.jpg" />
				<h4 class="col-md-4">Portakal</h3>
				<h6 class="col-md-3">Adet</h5>
				<h6 class="col-md-2">10 TL</h5>
			</a>
			
			<a href="#" class="list-group-item row vertical-align">
				<img class="img-circle col-md-2" height="64px"  src="http://organikerzincanbali.com/images/bal/bal5.jpg" />
				<h4 class="col-md-4">Limon</h3>
				<h6 class="col-md-3">Adet</h5>
				<h6 class="col-md-2">10 TL</h5>
			</a>
			
			<a href="#" class="list-group-item row vertical-align">
				<img class="img-circle col-md-2" height="64px"  src="http://organikerzincanbali.com/images/bal/bal5.jpg" />
				<h4 class="col-md-4">Elma</h3>
				<h6 class="col-md-3">Adet</h5>
				<h6 class="col-md-2">10 TL</h5>
			</a>
			
			<a href="#" class="list-group-item row vertical-align">
				<img class="img-circle col-md-2" height="64px"  src="http://organikerzincanbali.com/images/bal/bal5.jpg" />
				<h4 class="col-md-4">Portakal</h3>
				<h6 class="col-md-3">Adet</h5>
				<h6 class="col-md-2">10 TL</h5>
			</a>
			
			<a href="#" class="list-group-item row vertical-align">
				<img class="img-circle col-md-2" height="64px"  src="http://organikerzincanbali.com/images/bal/bal5.jpg" />
				<h4 class="col-md-4">Portakal</h3>
				<h6 class="col-md-3">Adet</h5>
				<h6 class="col-md-2">10 TL</h5>
			</a>
			
			<a href="#" class="list-group-item row vertical-align">
				<img class="img-circle col-md-2" height="64px"  src="http://organikerzincanbali.com/images/bal/bal5.jpg" />
				<h4 class="col-md-4">Portakal</h3>
				<h6 class="col-md-3">Adet</h5>
				<h6 class="col-md-2">10 TL</h5>
			</a>
			
			<a href="#" class="list-group-item row vertical-align">
				<img class="img-circle col-md-2" height="64px"  src="http://organikerzincanbali.com/images/bal/bal5.jpg" />
				<h4 class="col-md-4">Portakal</h3>
				<h6 class="col-md-3">Adet</h5>
				<h6 class="col-md-2">10 TL</h5>
			</a>
			
		</div>
	</div>
	<div class="col-md-4 col-md-offset-1 rcorners2" style="margin-bottom:3em;">Total</div>
</div>

<div class="row">
	<div class="rcorners2">
		Shopping Cart
	</div>
</div>
<!-- 
<table>
<tr>
<td>
<p class="rcorners2" style="width:800px"> Products</p>
</td>
<td>
<p class="rcorners2" style="width:400px"> Products</p>
</td>
</tr>
<tr>
<td>
<p class="rcorners2" style="width:1200px"> Shopping Cart</p>
</td>
</tr>
</table>
 -->
</div>


</jsp:attribute>
</mt:myTemplate>
