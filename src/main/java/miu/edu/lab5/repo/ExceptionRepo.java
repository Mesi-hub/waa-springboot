package miu.edu.lab5.repo;

import miu.edu.lab5.entity.ExceptionEntry;
import org.springframework.data.repository.CrudRepository;

public interface ExceptionRepo extends CrudRepository<ExceptionEntry, Integer> {
}