package miu.edu.lab6.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "Logger")
public class LogEntry {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    int id;
    private String principle;
    private String operation;
    private Date date;
    private String executionTime;
}