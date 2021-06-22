<jsp:include page="cheader.jsp"></jsp:include>
<div class="container-fluid">
  <div class="row mt-2">
       <div class="col-md-4 offset-md-4 admin" >
            <div class="card">
            
              <div class="card-body px-5">
            <img src="images/download.jpg" class="rounded mx-auto d-block" alt="img" height="190px" width="190px">
            <h2 class="text-center my-3">Register New Account</h2>
            <form autocomplete="off" action="/register/" method="post">
            
            <div class="form-group">
                     <label>First Name</label>
                     <input type="text" class="form-control" name="fname" placeholder="First Name" required>
            </div>         
            <div class="form-group">
                     <label>Last Name</label>
                     <input type="text" class="form-control" name="lname" placeholder="Last Name" required>
            </div>
            <div class="form-group">
                     <label>User ID</label>
                     <input type="text" class="form-control" name="userid" placeholder="User ID" required>
            </div>
            <div class="form-group">
                     <label>User DOB</label>
                     <input type="date" class="form-control" name="dob" required>   
            </div>
            <div class="form-group">
                     <label>Gender</label>
                      <select name="gender" required 
                                            >
                                            <option>Male</option>
                                            <option>Female</option>
                                            </select>           
            </div>
            <div class="form-group">
                     <label>User Email</label>
                     <input type="text" class="form-control" aria-describedby="emailHelp" name="email" placeholder="Enter Email" required>
            </div>
            <div class="form-group">
                     <label>User Password</label>
                     <input type="password" class="form-control" name="pwd" placeholder="Enter Password" required>
            </div>
             <div class="form-group">
                     <label>Repeat Password</label>
                     <input type="password" class="form-control" name="cpwd" placeholder="Repeat Password" required>
            </div>
             <div class="form-group">
                     <label>Address</label>
                     <textarea type="text" class="form-control" name="address" placeholder="Address" required></textarea>
            </div>
            
 
                <div class="buttons"><div><button class="grey">Create Account</button></div></div>
                <p class="terms">By clicking 'Create Account' you agree to the <a href="#">Terms &amp; Conditions</a>.</p>
                <div class="clear"></div>
            </form>
        </div>  	
        <div class="clear"></div>
    </div>
</div>
</div></div>
<jsp:include page="cfooter.jsp"></jsp:include>