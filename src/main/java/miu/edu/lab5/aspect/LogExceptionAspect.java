package miu.edu.lab5.aspect;

import miu.edu.lab5.entity.ExceptionEntry;
import miu.edu.lab5.repo.ExceptionRepo;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class LogExceptionAspect {
    @Autowired
    ExceptionRepo exceptionRepo;
    @Pointcut("execution(* miu.edu.lab5.*.*(..)) && " +
            "!execution(* miu.edu.lab5.repo.ExceptionRepo.*(..)) &&" +
            "!execution(* miu.edu.lab5.aspect.LogExceptionAspect.*(..))")
    private void logException() {}

    @AfterThrowing(pointcut="logException()", throwing = "ex")
    public void logExceptionDetails(Throwable ex) {
        saveLog(ex);
    }

    private void saveLog(Throwable ex){
        var exception = new ExceptionEntry();

        exception.setPrinciple("hi mes");
        exception.setOperation(ex.getMessage());
        exception.setExceptionType(ex.getStackTrace()[0].getClassName());
        exception.setDate(new Date());

        exceptionRepo.save(exception);
    }
}