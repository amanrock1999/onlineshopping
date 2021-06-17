<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="cheader.jsp"></jsp:include>
<div class="header_bottom">
	<!-- FlexSlider -->
	<div id="ce" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#ce" data-slide-to="0" class="active"></li>
			<li data-target="#ce" data-slide-to="1"></li>
			<li data-target="#ce" data-slide-to="2"></li>
			<li data-target="#ce" data-slide-to="3"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100" style="height: 100%"
					src="images/slide1.jpg" alt="First slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" style="height: 100%"
					src="images/slide2.jpg" alt="Second slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" style="height: 100%"
					src="images/slide3.jpg" alt="Third slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" style="height: 100%"
					src="images/slide4.png" alt="Fourth slide">
			</div>
		</div>
		<a class="carousel-control-prev" href="#ce" role="button"
			data-slide="prev"> <span class="carousel-control-prev-icon"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#ce" role="button"
			data-slide="next"> <span class="carousel-control-next-icon"
			aria-hidden="true"></span> <span class="sr-only">Next</span>
		</a>
	</div>
	<!-- FlexSlider -->
</div>
<div class="main">

	<div class="content">

		<div class="container">
			<div class="row">
				<c:forEach items="${prods }" var="p">
					<div class="col-sm-3">
						<div class="card shadow my-1">

							<div class="card-body text-center">
								<a href="/addtocart/${p.prodid}"> <img style="height: 200px;"
									class="img-thumbnail card-img-top" src="${p.pic}" alt="" /></a>
								<h2 class="p-2" style="font-size: 14px;">${p.pname}</h2>
								<p style="margin-bottom: 5px;">
									<span>&#8377;${p.price}</span>
								</p>
								<div class="button" style="margin: auto">
									<a href="addtocart/${p.prodid}" class="btn btn-success btn-block"><i
										class="fa fa-cart"></i>Add to Cart</a>
								</div>
							</div>

						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<jsp:include page="cfooter.jsp"></jsp:include>