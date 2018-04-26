package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Observaciones;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Observaciones entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ObservacionesRepository extends JpaRepository<Observaciones, Long> {

}
