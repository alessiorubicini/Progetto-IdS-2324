package it.unicam.cs.opencity.repository;

import it.unicam.cs.opencity.entity.Content;
import it.unicam.cs.opencity.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, Integer> {
    List<Point> findByCityId(Integer cityId);
}