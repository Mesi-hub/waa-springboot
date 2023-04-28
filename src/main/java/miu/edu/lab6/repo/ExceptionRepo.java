package miu.edu.lab6.repo;

import miu.edu.lab6.entity.ExceptionEntry;
import org.springframework.data.repository.CrudRepository;

public interface ExceptionRepo extends CrudRepository<ExceptionEntry, Integer> {
}