package io.github.jinyoungyou.hexagonalmodulith.journal.adapter.in.web;

import io.github.jinyoungyou.hexagonalmodulith.journal.adapter.in.web.dto.IncomeResponse;
import io.github.jinyoungyou.hexagonalmodulith.journal.adapter.in.web.dto.RegisterIncomeRequest;
import io.github.jinyoungyou.hexagonalmodulith.journal.application.port.in.GetAllIncomeUseCase;
import io.github.jinyoungyou.hexagonalmodulith.journal.application.port.in.RegisterIncomeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/journal")
public class JournalController {

    private final RegisterIncomeUseCase registerIncomeUseCase;
    private final GetAllIncomeUseCase getAllIncomeUseCase;

    @GetMapping("/income")
    public List<IncomeResponse> getAllIncome() {

        return getAllIncomeUseCase.getAllIncome().stream()
                .map(i -> new IncomeResponse(i.getId(),
                        i.getDateTime(),
                        i.getAccountId(),
                        i.getMoney(),
                        i.getCategoryId(),
                        i.getDescription()))
                .toList();
    }

    @PostMapping("/income")
    public void registerIncome(@RequestBody RegisterIncomeRequest registerIncomeRequest) {
        var registerIncomeCommand = new RegisterIncomeUseCase.RegisterIncomeCommand(
                registerIncomeRequest.dateTime(),
                registerIncomeRequest.accountId(),
                registerIncomeRequest.money(),
                registerIncomeRequest.categoryId(),
                registerIncomeRequest.description());
        
        registerIncomeUseCase.registerIncome(registerIncomeCommand);
    }
}
