package io.github.jinyoungyou.hexagonalmodulith.journal.adapter.out.persistence;

import io.github.jinyoungyou.hexagonalmodulith.journal.domain.Income;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class IncomeRepository {

    private final static Map<Long, Income> incomes = new ConcurrentHashMap<>();

    public void save(Income income) {
        incomes.put(income.getId(), income);
    }

    @SuppressWarnings("unused")
    public Income getById(Long id) {
        return incomes.computeIfAbsent(id, k -> {
            throw new NoSuchElementException();
        });
    }

    public List<Income> getAll() {
        return incomes.values().stream().toList();
    }
}
