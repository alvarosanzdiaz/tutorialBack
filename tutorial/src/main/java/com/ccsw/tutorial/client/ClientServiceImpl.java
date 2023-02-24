package com.ccsw.tutorial.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.client.model.ClientDto;
import com.ccsw.tutorial.exception.AlreadyExistsException;

/**
 * @author ccsw
 *
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    /**
     * {@inheritDoc}
     */
    public Client get(Long id) {

        return this.clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> findAll() {

        return (List<Client>) this.clientRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Long id, ClientDto dto) throws AlreadyExistsException {

        Client client = null;

        if (this.clientRepository.findByName(dto.getName()).size() > 0) {
            throw new AlreadyExistsException();
        }
        ;

        if (id == null)
            client = new Client();
        else
            client = this.get(id);

        client.setName(dto.getName());

        this.clientRepository.save(client);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {

        this.clientRepository.deleteById(id);

    }
}
