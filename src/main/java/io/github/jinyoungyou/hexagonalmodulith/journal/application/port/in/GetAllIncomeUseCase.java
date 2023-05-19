package io.github.jinyoungyou.hexagonalmodulith.journal.application.port.in;

import io.github.jinyoungyou.hexagonalmodulith.journal.domain.Income;

import java.util.List;

public interface GetAllIncomeUseCase {

    List<Income> getAllIncome();
}
