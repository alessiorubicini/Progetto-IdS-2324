package it.unicam.cs.opencity.repository;

import it.unicam.cs.opencity.entity.Content;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer>{
}
