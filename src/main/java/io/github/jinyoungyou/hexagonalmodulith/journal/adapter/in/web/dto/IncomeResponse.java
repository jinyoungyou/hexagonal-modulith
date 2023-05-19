package io.github.jinyoungyou.hexagonalmodulith.journal.adapter.in.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record IncomeResponse(
        Long id,
        LocalDateTime dateTime,
        Long accountId,
        BigDecimal money,
        Long categoryId,
        String description) {
}
