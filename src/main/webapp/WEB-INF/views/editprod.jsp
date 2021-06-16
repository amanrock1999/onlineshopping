<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<jsp:include page="header.jsp"></jsp:include>
 <h5 class="modal-title" id="exampleModalLongTitle" >Update Product.</h5>
<jsp:include page="msg.jsp"></jsp:include>

<div class="container-fluid">
  	<div class="row mt-2">
         <div class="col-md-4 offset-md-4 admin">
            
              <div class="card">
      <div class="modal-header custom-bg text-white">
       
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="card-body">
      
          <form method="post" action="/editprod/${p.prodid}">
          
        
					     <div class="container text-center">
					                   <img src="${p.pic}" class="mr-2"
										style="width: 80px; height: 60px;">
					         </div> 
					     
					    <div class="form-group">
					      <label>Name</label>
					      <input type="text" class="form-control" name="pname" value="${p.pname}" required>
					    </div>
					    <div class="form-group">
					      <label>Brand</label>
					      <input class="form-control" type="text" name="company" value="${p.company}" required>
					    </div>
					    <div class="form-row">
					    <div class="form-group col-md-4">
					      <label>Free Delivery Eligible</label>
					      <input type="text" class="form-control" name="salt" value="${p.salt}" required>
					    </div>
					    
					    <div class="form-group col-md-4">
					      <label>Launch Date</label>     
					      <input type="month" class="form-control" name="mfg" value="${p.mfgdate}" required>
					    </div>
					    
					    <div class="form-group col-md-4">
					      <label>Product Add Date</label>
					      <input type="month" class="form-control" name="expiry" value="${p.expirydate}" required>
					    </div>
					   </div>
					   
					   <div class="form-group">
					                   <label>Quantity</label><br>
					                   <input type="text" class="form-control" name="qty" value="${p.qty}"  required>     
					               </div>
					   
					               <div class="form-group">
					                   <label>Price</label><br>
					                   <input type="text" class="form-control" name="price" value="${p.price}"  required>     
					               </div>
					                 <div class="form-group">
					                   <label>Category</label><br>
					                   <select name="catid" required
														class="form-control" value="${catid}">
														<option value="">Select Category</option>
														<c:forEach items="${cats }" var="cat">
															<option value="${cat.catid}">${cat.catname}</option>
														</c:forEach>
													</select>     
					               </div>
					               
					               
					            
					               
					
					   
					   <div class="container text-center">
					                   <input type="submit" class="btn custom-bg text-white" value="Update Product">
					                   <!-- <button type="button" class="btn btn-secondary ml-5" data-dismiss="modal">Close</button> -->
					               </div> 
    
</form>   
         
      </div>
    </div>
  </div>
</div>   
</div>
<jsp:include page="footer.jsp"></jsp:include>