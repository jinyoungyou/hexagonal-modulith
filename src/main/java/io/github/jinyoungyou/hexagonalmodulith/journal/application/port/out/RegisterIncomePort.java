package io.github.jinyoungyou.hexagonalmodulith.journal.application.port.out;

import io.github.jinyoungyou.hexagonalmodulith.journal.domain.Income;

public interface RegisterIncomePort {

    void registerIncome(Income income);
}
