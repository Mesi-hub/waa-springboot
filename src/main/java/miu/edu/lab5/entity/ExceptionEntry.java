package miu.edu.lab5.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@Setter
@Getter
@Table(name = "log_exceptions")
public class ExceptionEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String principle;
    String operation;
    String exceptionType;
    Date date;
}