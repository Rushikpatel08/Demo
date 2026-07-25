package com.example.demo.Repository;

import com.example.demo.Entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface mobileRepository extends JpaRepository<Mobile, Long>{


    List<Mobile> findByBrand(String brand);
}
