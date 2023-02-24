package com.ccsw.tutorial.client;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.tutorial.client.model.Client;

/**
 * @author ccsw
 */
public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findByName(String name);
}
