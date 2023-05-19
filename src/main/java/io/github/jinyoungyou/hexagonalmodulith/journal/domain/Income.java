package io.github.jinyoungyou.hexagonalmodulith.journal.domain;

import io.github.jinyoungyou.hexagonalmodulith.common.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class Income {

    protected Long id;

    @NotNull
    protected LocalDateTime dateTime;

    @NotNull
    protected Long accountId;

    @NotNull
    protected BigDecimal money;

    protected Long categoryId;

    protected String description;

    public Income(@NotNull LocalDateTime dateTime,
                  @NotNull Long accountId,
                  @NotNull BigDecimal money,
                  Long categoryId,
                  String description) {
        this.id = SequenceGenerator.nextId();
        this.dateTime = dateTime;
        this.accountId = accountId;
        this.money = money;
        this.categoryId = categoryId;
        this.description = description;
    }
}
