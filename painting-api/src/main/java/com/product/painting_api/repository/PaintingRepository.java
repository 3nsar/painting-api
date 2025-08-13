package com.product.painting_api.repository;

import com.product.painting_api.entity.Painting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaintingRepository extends JpaRepository<Painting,Integer> {
}
