package com.ccsw.tutorial.loan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.game.model.Game;

/**
 * @author ccsw
 */
@Entity
@Table(name = "Loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "initial_date", nullable = false)
    private Date initialDate;

    @Column(name = "final_date", nullable = false)
    private Date finalDate;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

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
    public Game getGame() {

        return this.game;
    }

    public Date getfinalDate() {
        return finalDate;
    }

    public void setfinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    /**
     * @param game new value of {@link #getGame}.
     */
    public void setGame(Game game) {

        this.game = game;
    }

    /**
     * @return client
     */
    public Client getClient() {

        return this.client;
    }

    /**
     * @param client new value of {@link #getCliente}.
     */
    public void setClient(Client client) {

        this.client = client;
    }

}
