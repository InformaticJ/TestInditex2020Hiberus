package com.inditex.test.infrastructure.rest.outputadapter;

import com.inditex.test.infrastructure.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface RepositoryPrice extends JpaRepository<PriceEntity,Integer> {
    List<PriceEntity> findByProductIdAndBrandId(Integer ProductId,Integer BrandId);
}
