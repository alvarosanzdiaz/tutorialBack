package com.ccsw.tutorial.loan;

import java.util.Date;

import org.springframework.data.domain.Page;

import com.ccsw.tutorial.loan.model.Loan;
import com.ccsw.tutorial.loan.model.LoanDto;
import com.ccsw.tutorial.loan.model.LoanSearchDto;

/**
 * @author ccsw
 */
public interface LoanService {

    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.author.model.Author}
     * 
     * @param dto
     * @return
     */
    Page<Loan> findPage(LoanSearchDto dto);

    Page<Loan> find(LoanSearchDto dto, Long gameId, Long clientId, Date initialDate);

    /**
     * Método para crear o actualizar un
     * {@link com.ccsw.tutorial.author.model.Author}
     * 
     * @param id
     * @param data
     */
    void save(Long id, LoanDto data);

    boolean isLoanFree(LoanDto data);

    boolean exceedLoan(LoanDto data);

    void delete(Long id);

}