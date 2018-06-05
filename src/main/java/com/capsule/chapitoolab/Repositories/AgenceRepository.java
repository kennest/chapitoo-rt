package com.capsule.chapitoolab.Repositories;

import com.capsule.chapitoolab.models.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends JpaRepository<Agence,Long> {
    @Query(" select a from Agence a " + " where a.email = ?1")
    Agence findUserWithEmail(String email);
}