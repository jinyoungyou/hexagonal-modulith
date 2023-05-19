package io.github.jinyoungyou.hexagonalmodulith.journal.application.port.in;

import io.github.jinyoungyou.hexagonalmodulith.common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface RegisterIncomeUseCase {

    void registerIncome(RegisterIncomeCommand registerIncomeCommand);

    @Getter
    final class RegisterIncomeCommand extends SelfValidating<RegisterIncomeCommand> {

        @NotNull
        private final LocalDateTime dateTime;

        @NotNull
        private final Long accountId;

        @NotNull
        @PositiveOrZero
        private final BigDecimal money;

        private final Long categoryId;

        private final String description;

        public RegisterIncomeCommand(@NotNull LocalDateTime dateTime,
                                     @NotNull Long accountId,
                                     @NotNull BigDecimal money,
                                     Long categoryId,
                                     String description) {
            this.dateTime = dateTime;
            this.accountId = accountId;
            this.money = money;
            this.categoryId = categoryId;
            this.description = description;
            validateSelf();
        }
    }
}
