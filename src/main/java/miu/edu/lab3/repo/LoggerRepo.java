package miu.edu.lab3.repo;

import miu.edu.lab3.entity.LogEntry;
import org.springframework.data.repository.CrudRepository;

public interface LoggerRepo extends CrudRepository <LogEntry, Integer> {
}
