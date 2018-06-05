package com.capsule.chapitoolab.Repositories;

import com.capsule.chapitoolab.models.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommuneRepository extends JpaRepository<Commune, Long> {

}
