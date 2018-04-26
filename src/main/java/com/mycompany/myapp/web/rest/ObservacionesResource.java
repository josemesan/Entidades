package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.domain.Observaciones;

import com.mycompany.myapp.repository.ObservacionesRepository;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Observaciones.
 */
@RestController
@RequestMapping("/api")
public class ObservacionesResource {

    private final Logger log = LoggerFactory.getLogger(ObservacionesResource.class);

    private static final String ENTITY_NAME = "observaciones";

    private final ObservacionesRepository observacionesRepository;

    public ObservacionesResource(ObservacionesRepository observacionesRepository) {
        this.observacionesRepository = observacionesRepository;
    }

    /**
     * POST  /observaciones : Create a new observaciones.
     *
     * @param observaciones the observaciones to create
     * @return the ResponseEntity with status 201 (Created) and with body the new observaciones, or with status 400 (Bad Request) if the observaciones has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/observaciones")
    @Timed
    public ResponseEntity<Observaciones> createObservaciones(@RequestBody Observaciones observaciones) throws URISyntaxException {
        log.debug("REST request to save Observaciones : {}", observaciones);
        if (observaciones.getId() != null) {
            throw new BadRequestAlertException("A new observaciones cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Observaciones result = observacionesRepository.save(observaciones);
        return ResponseEntity.created(new URI("/api/observaciones/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /observaciones : Updates an existing observaciones.
     *
     * @param observaciones the observaciones to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated observaciones,
     * or with status 400 (Bad Request) if the observaciones is not valid,
     * or with status 500 (Internal Server Error) if the observaciones couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/observaciones")
    @Timed
    public ResponseEntity<Observaciones> updateObservaciones(@RequestBody Observaciones observaciones) throws URISyntaxException {
        log.debug("REST request to update Observaciones : {}", observaciones);
        if (observaciones.getId() == null) {
            return createObservaciones(observaciones);
        }
        Observaciones result = observacionesRepository.save(observaciones);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, observaciones.getId().toString()))
            .body(result);
    }

    /**
     * GET  /observaciones : get all the observaciones.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of observaciones in body
     */
    @GetMapping("/observaciones")
    @Timed
    public List<Observaciones> getAllObservaciones() {
        log.debug("REST request to get all Observaciones");
        return observacionesRepository.findAll();
        }

    /**
     * GET  /observaciones/:id : get the "id" observaciones.
     *
     * @param id the id of the observaciones to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the observaciones, or with status 404 (Not Found)
     */
    @GetMapping("/observaciones/{id}")
    @Timed
    public ResponseEntity<Observaciones> getObservaciones(@PathVariable Long id) {
        log.debug("REST request to get Observaciones : {}", id);
        Observaciones observaciones = observacionesRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(observaciones));
    }

    /**
     * DELETE  /observaciones/:id : delete the "id" observaciones.
     *
     * @param id the id of the observaciones to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/observaciones/{id}")
    @Timed
    public ResponseEntity<Void> deleteObservaciones(@PathVariable Long id) {
        log.debug("REST request to delete Observaciones : {}", id);
        observacionesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
