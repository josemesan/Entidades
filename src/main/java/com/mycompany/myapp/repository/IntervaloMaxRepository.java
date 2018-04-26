package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.IntervaloMax;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the IntervaloMax entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IntervaloMaxRepository extends JpaRepository<IntervaloMax, Long> {

}
