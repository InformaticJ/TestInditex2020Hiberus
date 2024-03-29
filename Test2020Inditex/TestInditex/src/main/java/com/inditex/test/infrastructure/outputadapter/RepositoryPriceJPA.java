package com.inditex.test.infrastructure.outputadapter;
import com.inditex.test.infrastructure.outputadapter.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Repository
public interface RepositoryPriceJPA extends JpaRepository<PriceEntity,Integer> {
    @Query("SELECT e FROM PriceEntity e WHERE e.startDate <= :date AND e.endDate >= :date AND e.brandId = :brandId AND e.productId = :productId")
    List<PriceEntity> findByDateBetweenAndBrandIdAndProductId(@Param("date") LocalDateTime date, @Param("productId") Integer productId, @Param("brandId")Integer brandId);
}
