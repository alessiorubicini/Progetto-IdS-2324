package it.unicam.cs.opencity.repository;

import it.unicam.cs.opencity.entity.Participation;
import it.unicam.cs.opencity.entity.ParticipationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, ParticipationId> {
    List<Participation> findByIdUserId(Integer id);
}
