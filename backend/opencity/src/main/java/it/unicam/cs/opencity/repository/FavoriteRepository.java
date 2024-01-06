package it.unicam.cs.opencity.repository;

import it.unicam.cs.opencity.entity.Favorite;
import it.unicam.cs.opencity.entity.FavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, FavoriteId> {
}