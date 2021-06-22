package com.example;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.repos.CategoryRepository;
import com.example.repos.CustomerRepository;
import com.example.repos.ProductRepository;
import com.example.service.CategoryService;
import com.example.service.CustomerService;
import com.example.service.ProductService;
import com.example.models.Customer;
import com.example.models.Product;
import com.example.models.Category;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;


@RunWith(SpringRunner.class)
@SpringBootTest
class OnlineshoppingApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired private CustomerService srv;
	@Autowired private ProductService prosrv;
	@Autowired private CategoryService catsrv;
	
	
 	@MockBean private CategoryRepository catrepo;
	@MockBean private CustomerRepository cusrepo;
	@MockBean private ProductRepository prorepo;
	
	
	
	
	@Test
	public void getCustomersTest()
	{
		when(cusrepo.findAll()).thenReturn(Stream.of(new Customer("shiv","shiv","shiv","shiv","00-00-0000","male","shiv@gmail.com","address"),
				new Customer("aman","aman","aman","gupta","03-08-1999","male","aman@gmail.com","address")).collect(Collectors.toList()));
		
		assertEquals(2,srv.allCustomers().size());	
	}
	
	@Test
	public void getCustomersByAddress()
	{
		String add="surat";
		when(cusrepo.findByAddress(add)).thenReturn(Stream.of(new Customer("shiv","shiv","shiv","shiv","00-00-0000","male","shiv@gmail.com","address")).collect(Collectors.toList()));
		assertEquals(1,srv.getCustomerByAddress(add).size());
	} 
	
	@Test
	public void saveCustomerTest()
	{
		Customer cus = new Customer("shiv","shiv","shiv","shiv","00-00-0000","male","shiv@gmail.com","address");
		when(cusrepo.save(cus)).thenReturn(cus);
		assertEquals(cus,srv.saveCustomer(cus));
	}
	
	@Test
	public void deleteCustomertest()
	{
		Customer cus = new Customer("aman","aman","aman","gupta","03-08-1999","male","aman@gmail.com","address");
		srv.deleteCustomer(cus);
		verify(cusrepo, times(1)).delete(cus);
	}
	
	@Test
	public void getCustomerByUserid()
	{
		String userid="aman";
		when(cusrepo.findByUserid(userid)).thenReturn(Stream.of(new Customer("shiv","shiv","shiv","shiv","00-00-0000","male","shiv@gmail.com","address")).collect(Collectors.toList()));
		assertEquals(1,srv.getCustomerByUerid(userid).size());
	}
	
	@Test
	public void getProductTest()
	{
		Category c = new Category(1,"mobile");
		when(prorepo.findByDeletedOrderByProdidDesc(false)).thenReturn(Stream.of(new Product(1,"iphone","apple","yes",c,"pic",1,true,100)).collect(Collectors.toList()));
		
		assertEquals(1,prosrv.allProducts().size());	
		
	}
	
	@Test
	public void allcategoryproducttest()
	{
		
		Category c = new Category(1,"mobile");
		int catid=1;
		when(prorepo.findByCatidOrderByProdidDesc(catid)).thenReturn(Stream.of(new Product(1,"iphone","apple","yes",c,"pic",1,true,100)).collect(Collectors.toList()));
		
		assertEquals(1,prosrv.allCategoryProducts(catid).size());	
	}
	
	
	@Test
	public void getbynametest()
	{
		
		Category c = new Category(1,"mobile");
		String name="samsung";
		when(prorepo.findByName(name)).thenReturn(Stream.of(new Product(1,"iphone","apple","yes",c,"pic",1,true,100)).collect(Collectors.toList()));
		
		assertEquals(1,prosrv.allSearchProducts(name).size());	
	}
	
	@Test 
	public void totalcategorytest()
	{
		catrepo.count();
		assertEquals(0,catsrv.totalCategories());
	}
	

}
