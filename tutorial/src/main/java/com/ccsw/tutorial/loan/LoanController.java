package com.ccsw.tutorial.loan;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.tutorial.config.mapper.BeanMapper;
import com.ccsw.tutorial.loan.model.Loan;
import com.ccsw.tutorial.loan.model.LoanDto;
import com.ccsw.tutorial.loan.model.LoanSearchDto;

/**
 * @author ccsw
 */
@RequestMapping(value = "/loan")
@RestController
@CrossOrigin(origins = "*")
public class LoanController {

    @Autowired
    LoanService loanService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<LoanDto> find(@RequestBody LoanSearchDto dto,
            @RequestParam(value = "gameId", required = false) Long gameId,
            @RequestParam(value = "clientId", required = false) Long clientId,
            @RequestParam(value = "initial_date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date initial_date) {

        Page<Loan> loans = loanService.find(dto, gameId, clientId, initial_date);

        return beanMapper.mapPage(loans, LoanDto.class);
    }

    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody LoanDto data) {

        this.loanService.save(id, data);
    }

    /**
     * Comprobacion de si el juego esta prestado a algun cliente ya
     */
    @RequestMapping(path = { "/check-disponibilidad" }, method = RequestMethod.POST)
    public boolean isLoanFree(@RequestBody LoanDto data) {

        return this.loanService.isLoanFree(data);
    }

    @RequestMapping(path = { "/check-exceed" }, method = RequestMethod.POST)
    public boolean exceedLoan(@RequestBody LoanDto data) {

        return this.loanService.exceedLoan(data);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {

        this.loanService.delete(id);
    }
}