package com.ccsw.tutorial.loan.model;

import java.util.Date;

import com.ccsw.tutorial.client.model.ClientDto;
import com.ccsw.tutorial.game.model.GameDto;

/**
 * @author ccsw
 */
public class LoanDto {

    private Long id;

    private Date initialDate;

    private Date finalDate;

    private GameDto game;

    private ClientDto client;

    /**
     * @return id
     */
    public Long getId() {

        return this.id;
    }

    /**
     * @param id new value of {@link #getId}.
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * @return fechainicial
     */
    public Date getInitialDate() {

        return this.initialDate;
    }

    /**
     * @param fechainicial new value of {@link #getTitle}.
     */
    public void setInitialDate(Date initialDate) {

        this.initialDate = initialDate;
    }

    /**
     * @return finalDate
     */

    /**
     * @return game
     */
    public GameDto getGame() {

        return this.game;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    /**
     * @param game new value of {@link #getGame}.
     */
    public void setGame(GameDto game) {

        this.game = game;
    }

    /**
     * @return client
     */
    public ClientDto getClient() {

        return this.client;
    }

    /**
     * @param client new value of {@link #getCliente}.
     */
    public void setClient(ClientDto client) {

        this.client = client;
    }

}
