package com.ccsw.tutorial.loan;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.client.ClientService;
import com.ccsw.tutorial.game.GameService;
import com.ccsw.tutorial.loan.model.Loan;
import com.ccsw.tutorial.loan.model.LoanDto;
import com.ccsw.tutorial.loan.model.LoanSearchDto;

/**
 * @author ccsw
 */
@Service
@Transactional
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    LoanService loanService;

    @Autowired
    GameService gameService;

    @Autowired
    ClientService clientService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Loan> findPage(LoanSearchDto dto) {

        return this.loanRepository.findAll(dto.getPageable());
    }

    /**
     * {@inheritDoc}
     */
    public Page<Loan> find(LoanSearchDto dto, Long gameId, Long clientId, Date initial_date) {

        return this.loanRepository.find(dto.getPageable(), gameId, clientId, initial_date);
    }

    @Override
    public void save(Long id, LoanDto dto) {

        Loan loan = null;
        if (id != null)
            loan = this.loanRepository.findById(id).orElse(null);
        else
            loan = new Loan();
        BeanUtils.copyProperties(dto, loan, "id", "game", "client");

        loan.setClient(clientService.get(dto.getClient().getId()));
        loan.setGame(gameService.get(dto.getGame().getId()));

        this.loanRepository.save(loan);
    }

    @Override
    public boolean isLoanFree(LoanDto dto) {

        return this.loanRepository.findLoanByGameAndDates(dto.getGame().getId(), dto.getInitialDate(),
                dto.getFinalDate());

    }

    @Override
    public boolean exceedLoan(LoanDto dto) {

        int numPrestamos = this.loanRepository.countLoanByClientIdAndDates(dto.getClient().getId(),
                dto.getInitialDate(), dto.getFinalDate());

        // si excede el número de préstamos
        if (numPrestamos >= 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {

        this.loanRepository.deleteById(id);

    }

}