package miu.edu.lab3.repo;

import miu.edu.lab3.entity.ExceptionEntry;
import org.springframework.data.repository.CrudRepository;

public interface ExceptionRepo extends CrudRepository<ExceptionEntry, Integer> {
}