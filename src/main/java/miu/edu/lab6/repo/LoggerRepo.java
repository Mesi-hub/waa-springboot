package miu.edu.lab6.repo;

import miu.edu.lab6.entity.LogEntry;
import org.springframework.data.repository.CrudRepository;

public interface LoggerRepo extends CrudRepository <LogEntry, Integer> {
}
