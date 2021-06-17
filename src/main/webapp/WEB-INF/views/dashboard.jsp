<jsp:include page="header.jsp"></jsp:include>
 <div class="container admin mt-2">
	<h5 class="p-2" style="border-bottom: 2px solid green;">Dashboard</h5>
	<div class="row mt-3">
		
		<div class="col-md-4">
                 <div class="card hover">
                     <div class="card-body text-center">
                         <div class="container">
                             <img style="max-width:120px" class="img-fluid rounded-circle" src="images/user.png" alt="users_pic" >
                             <h4 class="text-uppercase text-muted">${totalusers}</h4>
                             <a href="/users" >
								<h5 class="text-uppercase text-muted" >USERS</h5>
							</a>
                         </div>
  
                         
                     </div>
                 </div>
           </div>
		
		
		<div class="col-md-4">
                  <div class="card hover">
                     <div class="card-body text-center">
                           <div class="container">
                             <img style="max-width:120px" class="img-fluid rounded-circle" src="images/product.png" alt="users_pic" >
                             <h4 class="text-uppercase text-muted">${totalproducts}</h4>
                             <a href="/products">
								<h5 class="text-uppercase text-muted">TOTAL PRODUCTS</h5>
							</a>
                           </div>
                           
                     </div>
                 </div>
           </div>
           
           

		
		
		<div class="col-md-4">
                  <div class="card hover">
                     <div class="card-body text-center">
                          <div class="container">
                             <img style="max-width:120px" class="img-fluid rounded-circle" src="images/category.png" alt="users_pic" >
                             <h4 class="text-uppercase text-muted">${totalcategories}</h4>
                             <a href="/categories" >
								<h5 class="text-uppercase text-muted">TOTAL CATEGORIES</h5>
							</a>
                         </div>
                     </div>
                 </div>
           </div>
           
           </div>
           
            <div class="row mt-3" >
           
	
		
		<div class="col-md-4">
                 <div class="card hover">
                     <div class="card-body text-center">
                         <div class="container">
                             <img style="max-width:120px" class="img-fluid rounded-circle" src="images/check.png" alt="users_pic" >
                             <h4 class="text-uppercase text-muted">${totalorders}</h4>
                             <a href="/orders">
				
									<h5 class="text-uppercase text-muted">TOTAL ORDERS</h5>
								</a>
                         </div>
                     </div>
                 </div>
           </div>
           
           
           
           
            <div class="col-md-4">
                  <div class="card hover" >
                     <div class="card-body text-center">
                          <div class="container md-5">
                             <img style="max-width:120px" class="img-fluid rounded-circle" src="images/addCategory.jpg" alt="users_pic" >
                                           
                     <a href="/categories">  <h4 class="text-lowercase text-muted mt-2 " style="font-size:22px">click to add category</h4></a>
                          <h5 class="text-uppercase text-muted mt-1">Add Category</h5>
                         </div>
                          
                     </div>
                 </div>
           </div>
           
           
           
            <div class="col-md-4">
                  <div class="card hover">
                     <div class="card-body text-center">
                          <div class="container">
                             <img style="max-width:120px" class="img-fluid rounded-circle" src="images/addproduct.png" alt="users_pic" >
            <a href="/products" ><h4 class="text-lowercase text-muted mt-2 " style="font-size:22px">click to add product</h4></a>
                             <h5 class="text-uppercase text-muted">Add Product</h5>
                         </div>
                     </div>
                 </div>
           </div>
           
           
	</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>