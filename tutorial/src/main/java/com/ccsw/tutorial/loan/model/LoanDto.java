package com.ccsw.tutorial.loan.model;

import java.util.Date;

import com.ccsw.tutorial.client.model.ClientDto;
import com.ccsw.tutorial.game.model.GameDto;

/**
 * @author ccsw
 */
public class LoanDto {

    private Long id;

    private Date initial_date;

    private Date final_date;

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
    public Date getInitial_date() {

        return this.initial_date;
    }

    /**
     * @param fechainicial new value of {@link #getTitle}.
     */
    public void setInitial_date(Date initial_date) {

        this.initial_date = initial_date;
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

    public Date getFinal_date() {
        return final_date;
    }

    public void setFinal_date(Date final_date) {
        this.final_date = final_date;
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
