package com.ccsw.tutorial.loan;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ccsw.tutorial.loan.model.Loan;

/**
 * @author ccsw
 */
public interface LoanRepository extends CrudRepository<Loan, Long> {

    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.author.model.Author}
     * 
     * @param page
     * @return
     */
    Page<Loan> findAll(Pageable pageable);
    // Query para aplicar los filtros correspondientes

    @Query("SELECT p FROM Loan p WHERE (:gameId IS NULL OR p.game.id = :gameId) AND (:clientId IS NULL OR p.client.id = :clientId) AND (:initial_date IS NULL OR (p.initialDate <= :initial_date AND p.finalDate > :initial_date))")
    Page<Loan> find(Pageable pageable, @Param("gameId") Long gameId, @Param("clientId") Long clientId,
            @Param("initial_date") Date initialDate);

    // Query para comprobar si el juego está prestado en un tiempo determinado
    @Query("SELECT CASE WHEN COUNT(p) > 1 THEN true ELSE false END FROM Loan p WHERE p.game.id = :gameId AND (:initial_date BETWEEN p.initialDate AND p.finalDate) OR  (:final_date BETWEEN p.initialDate AND p.finalDate) OR (:initial_date <= p.initialDate AND :final_date >= p.finalDate) OR (:initial_date > p.initialDate AND :final_date < p.finalDate)")
    boolean findLoanByGameAndDates(@Param("gameId") Long gameId, @Param("initial_date") Date initialDate,
            @Param("final_date") Date finalDate);

    // Query para obtener el número de préstamos de un cliente en un tiempo
    // determinado
    @Query("SELECT count(p) FROM Loan p WHERE p.client.id = :clientId AND (:initial_date BETWEEN p.initialDate AND p.finalDate OR :final_date BETWEEN p.initialDate AND p.finalDate)OR (:initial_date <= p.initialDate AND :final_date >= p.finalDate) OR (:initial_date > p.initialDate AND :final_date < p.finalDate)")
    int countLoanByClientIdAndDates(@Param("clientId") Long clientId, @Param("initial_date") Date initialDate,
            @Param("final_date") Date finalDate);

}