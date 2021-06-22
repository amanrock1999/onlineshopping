package com.example.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.models.Cart;
import com.example.models.Customer;
import com.example.models.Order;
import com.example.models.OrderDetails;
import com.example.models.Product;
import com.example.service.AdminUserService;
import com.example.service.CartService;
import com.example.service.CategoryService;
import com.example.service.CouponService;
import com.example.service.CustomerService;
import com.example.service.OrderDetailsService;
import com.example.service.OrderService;
import com.example.service.ProductService;

@Controller
@SessionAttributes({"cqty","userid","uname"})
public class HomeController {
	
	@Autowired
	private CategoryService catsrv;
	@Autowired private ProductService prodsrv;
	@Autowired private HttpSession session;
	@Autowired private CustomerService custsrv;
	@Autowired private AdminUserService adminsrv;
	@Autowired private CartService cartsrv;
	@Autowired private OrderService ordersrv;
	@Autowired private OrderDetailsService odsrv;
	@Autowired private CouponService cousrv;
	
	@GetMapping("/")
	public String homepage(Model model) {
		model.addAttribute("cats", catsrv.getAllCategories());
		model.addAttribute("prods", prodsrv.allProducts());
		return "index";
	}
	
	@GetMapping("/cats/{id}")
	public String listbycategory(Model model,@PathVariable("id") int id) {
		model.addAttribute("cats", catsrv.getAllCategories());
		model.addAttribute("prods", prodsrv.allCategoryProducts(id));
		return "catlist";
	}
	@GetMapping("/search")
	public String listbyname(Model model,String search) 
	{
		List<Product> prod = prodsrv.allSearchProducts(search);
		System.out.println(prod);
		model.addAttribute("prods", prod);
		return "searchlist";
	}
	
	@GetMapping("/addtocart/{id}")
	public String addtocart(Model model,@PathVariable("id") int id) {
		model.addAttribute("cats", catsrv.getAllCategories());
		model.addAttribute("p", prodsrv.findProductById(id));
		return "addtocart";
	}
	
	@PostMapping("/addtocart/{prodid}")
	public String saveItemtoCart(Cart c,Model model) {
		String userid=session.getAttribute("userid").toString();
		c.setUserid(userid);
		System.out.println(c);
		if(cartsrv.checkItem(c)) {
			session.setAttribute("error", "Item already in cart");
		}else {
			cartsrv.saveItem(c);
			model.addAttribute("cqty", cartsrv.getItemsinCart(userid));
			session.setAttribute("msg", "Item added to cart");
		}
		return "redirect:/";
	}
	
	@GetMapping("/invoice/{id}")
	public String invoice(@PathVariable("id") int orderid,Model model) {
		String userid = session.getAttribute("userid").toString();
		Order order=ordersrv.getOrderDetails(orderid);
		List<OrderDetails> odlist=odsrv.allItemsinOrder(orderid);
		System.out.println("Total items : "+odlist.size());
		model.addAttribute("cats", catsrv.getAllCategories());
		model.addAttribute("o", order);
		model.addAttribute("items",odlist);	
		model.addAttribute("add",custsrv.getCustAddress(userid));
		model.addAttribute("lname",custsrv.getCustLastName(userid));
		model.addAttribute("dist",cousrv.getCouponDistcount(order.getCode()));
		return "invoice";
	}
	
	@PostMapping("/placeorder")
	public String placeorder(Order order,Model model, String code) {
		String userid=session.getAttribute("userid").toString();
		int id=ordersrv.placeOrder(order,userid);
		ordersrv.setcode(code,id);
		model.addAttribute("cqty", cartsrv.getItemsinCart(userid));
		session.setAttribute("msg", "Order Placed Successfully");
		return "redirect:/invoice/"+id;
	}
	
	@GetMapping("/history")
	public String orderhistory(Model model) {
		String userid=session.getAttribute("userid").toString();
		model.addAttribute("cats", catsrv.getAllCategories());
		model.addAttribute("orders", ordersrv.allUserOrders(userid));
		return "history";
	}
	
	@GetMapping("/orderdetails/{id}")
	public String orderDetails(Model model,@PathVariable("id") int orderid) {
		String userid=session.getAttribute("userid").toString();
		Order order=ordersrv.getOrderDetails(orderid);
		List<OrderDetails> odlist=odsrv.allItemsinOrder(orderid);
		System.out.println("Total items : "+odlist.size());
		model.addAttribute("cats", catsrv.getAllCategories());
		model.addAttribute("o", order);
		model.addAttribute("items",odlist);		
		model.addAttribute("cqty", odlist.size());		
		return "order-details";
	}
	
	@GetMapping("/cancel/{id}")
	public String cancelOrder(@PathVariable("id") int orderid){
		ordersrv.cancelOrder(orderid);
		session.setAttribute("msg", "Order Cancelled successfully");
		return "redirect:/history";
	}
	
	
	@GetMapping("/cart")
	public String viewcart(Model model) {
		String userid=session.getAttribute("userid").toString();
		List<Cart> items=cartsrv.findItemsByUserId(userid);
		//int total=items.stream().reduce((i1,i2)->(i1.getQty()+i2.getQty()));
		int total=0;
		for(Cart i : items) {
			total+= (i.getQty()*i.getProduct().getPrice());
		}
		model.addAttribute("items", items);
		model.addAttribute("cqty", cartsrv.getItemsinCart(userid));
		model.addAttribute("ctotal", total);
		model.addAttribute("ctax", (total*.10));
		model.addAttribute("netamount", total+(total*.10));
		model.addAttribute("cats", catsrv.getAllCategories());
		return "cart";
	}
	
	@GetMapping("/delcart/{id}")
	public String deleteitemfromcart(@PathVariable("id") int id,Model model) {
		cartsrv.deleteItem(id);
		String userid=session.getAttribute("userid").toString();
		model.addAttribute("cqty", cartsrv.getItemsinCart(userid));
		session.setAttribute("msg", "Item deleted from cart");
		return "redirect:/cart";
	}
	
	@GetMapping("/login")
	public String loginpage(Model model) {
		model.addAttribute("cats", catsrv.getAllCategories());
		return "login";
	}
	
	@PostMapping("/login")
	public String validate(String userid,String pwd,Model model) {
		if(adminsrv.validate(userid, pwd)) {
			return "redirect:/dashboard";
		}
		else {
			Customer c=custsrv.ValidateLogin(userid, pwd);
			if(c!=null) {
				session.setAttribute("userid", userid);
				session.setAttribute("uname", c.getFname());
				model.addAttribute("cqty", cartsrv.getItemsinCart(userid));
				return "redirect:/";
			}
			else {
				session.setAttribute("error", "Invalid username or password");
				return "redirect:/login";
			}
		}		
	}
	
	@GetMapping("/register")
	public String Registerpage() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(Customer c) {
		Customer cust=custsrv.saveCustomer(c);
		session.setAttribute("userid", cust.getUserid());
		session.setAttribute("uname", cust.getFname());		
		return "redirect:/";
	}
	
	@GetMapping("/cchangepwd")
	public String changepasswordpage(Model model) {
		model.addAttribute("cats", catsrv.getAllCategories());
		return "changepwd";
	}
	
	@PostMapping("/cchangepwd")
	public String changepassword(String opwd,String pwd) {
		String userid=session.getAttribute("userid").toString();
		if(custsrv.updatePassword(userid, pwd, opwd)) {
			session.setAttribute("msg", "Password updated successfully");
		}
		else {
			session.setAttribute("error", "Incorrect current password");
		}
		return "redirect:/cchangepwd";
	}
}
