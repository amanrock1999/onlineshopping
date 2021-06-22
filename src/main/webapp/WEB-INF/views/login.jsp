<jsp:include page="cheader.jsp"></jsp:include>



<div class="container">
     <div class="row">
         <div class="col-md-6 offset-md-3 admin">
            
           <div class="card mt-3">
              
            <div class="card-header custom-bg text-white">
             <h3>Login here.!!</h3>
            </div>
             <div class="card-body">
            <form method="post" autocomplete="off">
            	<div class="form-group">
            	    <label>User ID</label>
                	<input type="text" class="form-control" name="userid" placeholder="User Id" required>
                </div>
                <div class="form-group">
                    <label>Password</label>
                	<input type="text" class="form-control" name="pwd" placeholder="Password" required>  
                </div> 
                           
                <div class="container text-center"><button class="btn text-white custom-bg">Sign In</button></div>
                
            </form>
            </div>
            
            <div class="container text-center mb-3">
            <h1>If not register <a href="/register">Click Here.</a></h1>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
</div>
<jsp:include page="cfooter.jsp"></jsp:include>