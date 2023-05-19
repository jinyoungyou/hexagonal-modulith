package io.github.jinyoungyou.hexagonalmodulith.journal.adapter.out.persistence;

import io.github.jinyoungyou.hexagonalmodulith.journal.application.port.out.GetAllIncomePort;
import io.github.jinyoungyou.hexagonalmodulith.journal.application.port.out.RegisterExpensePort;
import io.github.jinyoungyou.hexagonalmodulith.journal.application.port.out.RegisterIncomePort;
import io.github.jinyoungyou.hexagonalmodulith.journal.domain.Income;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalAdapter implements RegisterIncomePort, RegisterExpensePort, GetAllIncomePort {

    private final IncomeRepository incomeRepository;

    public JournalAdapter(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Override
    public void registerIncome(Income income) {
        incomeRepository.save(income);
    }

    @Override
    public List<Income> getAll() {
        return incomeRepository.getAll();
    }
}
