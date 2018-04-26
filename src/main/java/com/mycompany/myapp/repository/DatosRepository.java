package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Datos;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Datos entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DatosRepository extends JpaRepository<Datos, Long> {

}
