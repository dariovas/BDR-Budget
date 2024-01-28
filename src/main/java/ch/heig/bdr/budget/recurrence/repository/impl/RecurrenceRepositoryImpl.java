package ch.heig.bdr.budget.recurrence.repository.impl;

import ch.heig.bdr.budget.categorie.domain.Categorie;
import ch.heig.bdr.budget.depense.domain.Depense;
import ch.heig.bdr.budget.recurrence.domain.Recurrence;
import ch.heig.bdr.budget.recurrence.mapper.RecurrenceMapper;
import ch.heig.bdr.budget.recurrence.repository.RecurrenceRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecurrenceRepositoryImpl implements RecurrenceRepository {

    private RecurrenceMapper mapper;
    public RecurrenceRepositoryImpl(RecurrenceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Recurrence> getAllRecurrences(){
        return mapper.selectAll();
    }

    @Override
    public void addRecurrence(Recurrence recurrence) {
        mapper.insert(recurrence);
    }
}
