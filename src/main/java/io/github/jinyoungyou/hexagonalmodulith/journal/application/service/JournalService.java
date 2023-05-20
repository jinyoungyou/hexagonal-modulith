package io.github.jinyoungyou.hexagonalmodulith.journal.application.service;

import io.github.jinyoungyou.hexagonalmodulith.journal.application.port.in.GetAllIncomeUseCase;
import io.github.jinyoungyou.hexagonalmodulith.journal.application.port.in.RegisterIncomeUseCase;
import io.github.jinyoungyou.hexagonalmodulith.journal.application.port.out.GetAllIncomePort;
import io.github.jinyoungyou.hexagonalmodulith.journal.application.port.out.RegisterIncomePort;
import io.github.jinyoungyou.hexagonalmodulith.journal.domain.Income;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JournalService implements RegisterIncomeUseCase, GetAllIncomeUseCase {

    private final RegisterIncomePort registerIncomePort;
    private final GetAllIncomePort getAllIncomePort;

    @Override
    public void registerIncome(RegisterIncomeCommand registerJournalCommand) {
        var income = new Income(registerJournalCommand.getDateTime(),
                registerJournalCommand.getAccountId(),
                registerJournalCommand.getMoney(),
                registerJournalCommand.getCategoryId(),
                registerJournalCommand.getDescription());

        registerIncomePort.registerIncome(income);
    }

    @Override
    public List<Income> getAllIncome() {
        return getAllIncomePort.getAll();
    }
}
