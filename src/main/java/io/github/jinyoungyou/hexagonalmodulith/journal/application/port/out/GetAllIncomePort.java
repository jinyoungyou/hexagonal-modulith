package io.github.jinyoungyou.hexagonalmodulith.journal.application.port.out;

import io.github.jinyoungyou.hexagonalmodulith.journal.domain.Income;

import java.util.List;

public interface GetAllIncomePort {

    List<Income> getAll();
}
