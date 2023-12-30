package it.unicam.cs.opencity.repository;

import it.unicam.cs.opencity.entity.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContestRepository extends JpaRepository<Contest, Integer> {

}
