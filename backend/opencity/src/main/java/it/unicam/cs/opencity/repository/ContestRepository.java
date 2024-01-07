package it.unicam.cs.opencity.repository;

import it.unicam.cs.opencity.entity.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContestRepository extends JpaRepository<Contest, Integer> {
    List<Contest> findByCityId(Integer cityId);
}
