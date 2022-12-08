package com.inditex.test.repositories;

import com.inditex.test.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface RepositoryPrice extends JpaRepository<Price,Integer> {
    List<Price> findByStartDateAndProductIdAndBrandId(String startDate,Integer ProductId,Integer BrandId);

}
