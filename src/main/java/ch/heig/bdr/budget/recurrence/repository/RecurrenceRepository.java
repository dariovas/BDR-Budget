package ch.heig.bdr.budget.recurrence.repository;

import ch.heig.bdr.budget.recurrence.domain.Recurrence;
import java.util.List;

public interface RecurrenceRepository {
    List<Recurrence> getAllRecurrences();
    void addRecurrence(Recurrence recurrence);
    void addRecurrenceWithoutEnd(Recurrence recurrence);
}
