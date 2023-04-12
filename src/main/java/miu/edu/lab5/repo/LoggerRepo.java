package miu.edu.lab5.repo;

import miu.edu.lab5.entity.LogEntry;
import org.springframework.data.repository.CrudRepository;

public interface LoggerRepo extends CrudRepository <LogEntry, Integer> {
}
