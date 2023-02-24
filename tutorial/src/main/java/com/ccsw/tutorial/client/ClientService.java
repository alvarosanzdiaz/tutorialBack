package com.ccsw.tutorial.client;

import java.util.List;

import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.client.model.ClientDto;
import com.ccsw.tutorial.exception.AlreadyExistsException;

/**
 * @author ccsw
 *
 */
public interface ClientService {

    Client get(Long id);

    /**
     * Método para recuperar todas las {@link com.ccsw.tutorial.client.model.Client}
     * 
     * @return
     */
    List<Client> findAll();

    /**
     * Método para crear o actualizar uno
     * {@link com.ccsw.tutorial.client.model.Client}
     * 
     * @param dto
     * @return
     */
    void save(Long id, ClientDto dto) throws AlreadyExistsException;

    /**
     * Método para borrar uno {@link com.ccsw.tutorial.client.model.Client}
     * 
     * @param id
     */
    void delete(Long id);
}
