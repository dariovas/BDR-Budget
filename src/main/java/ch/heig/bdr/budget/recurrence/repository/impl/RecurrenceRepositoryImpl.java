package ch.heig.bdr.budget.recurrence.repository.impl;

import ch.heig.bdr.budget.recurrence.mapper.RecurrenceMapper;
import ch.heig.bdr.budget.recurrence.repository.RecurrenceRepository;
import org.springframework.stereotype.Repository;
@Repository
public class RecurrenceRepositoryImpl implements RecurrenceRepository {

    private RecurrenceMapper mapper;
    public RecurrenceRepositoryImpl(RecurrenceMapper mapper) {
        this.mapper = mapper;
    }
}
