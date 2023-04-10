package miu.edu.lab3.aspect;

import miu.edu.lab3.entity.LogEntry;
import miu.edu.lab3.repo.LoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    private LoggerRepo loggerRepo;


    @Pointcut("@annotation(miu.edu.lab3.aspect.annotation.LogInfo)")
    public void LogInfo(){}

    @Before("LogInfo()")
    public void logBefore(JoinPoint joinPoint) {
        logOperation(joinPoint);
    }

    public void logOperation(JoinPoint joinPoint) {
        String operation =  joinPoint.getSignature().toShortString();

        String principle = "hi me";

        LogEntry log = new LogEntry();
        log.setPrinciple(principle);
        log.setOperation(operation);
        log.setDate(new Date());

        this.saveLogEntry(log);
    }

    private void saveLogEntry(LogEntry log) {
        loggerRepo.save(log);
    }
}
