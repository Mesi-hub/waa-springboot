package miu.edu.lab6.aspect;

import miu.edu.lab6.entity.LogEntry;
import miu.edu.lab6.repo.LoggerRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;


@Aspect
@Component
public class ExecutionTimeAspect {
    @Autowired
    private LoggerRepo loggerRepo;

    @Pointcut("@annotation(miu.edu.lab6.aspect.annotation.ExecutionTime)")
    public void ExecutionTime() {

    }

    @Around("ExecutionTime()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        long exeTime = (finish - start);

        System.out.println(proceedingJoinPoint.getSignature().toShortString() + " takes ns: " + exeTime );

        String operation =  proceedingJoinPoint.getSignature().toShortString();

        String principle = "hi me";

        LogEntry log = new LogEntry();
        log.setPrinciple(principle);
        log.setOperation(operation);
        log.setExecutionTime(String.valueOf(exeTime) + " ns");
        log.setDate(new Date());

        this.saveLogEntry(log);

        return result;
    }

    private void saveLogEntry(LogEntry log) {
        loggerRepo.save(log);
    }

}