package io.github.jinyoungyou.hexagonalmodulith.journal.adapter.in.web.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RegisterIncomeRequest(
        @NotNull
        LocalDateTime dateTime,
        @NotNull
        Long accountId,
        @NotNull
        BigDecimal money,
        Long categoryId,
        String description) {

}
