package com.example.repos;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByDeletedOrderByProdidDesc(boolean isdeleted);
	
	List<Product> findByCatidOrderByProdidDesc(int catid);
	
	List<Product> findByExpirydateLessThanEqualOrderByExpirydateDesc(LocalDate date);
	
	@Query("SELECT p FROM Product p WHERE p.pname LIKE :n%")
	List<Product> findByName(@Param("n") String name);
	
}
