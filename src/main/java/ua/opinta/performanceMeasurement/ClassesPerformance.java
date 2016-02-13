package ua.opinta.performanceMeasurement;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class ClassesPerformance {

    public Object WatchTime(ProceedingJoinPoint joinPoint) {
        Object returnValue = null;

        long msDuration = System.currentTimeMillis();
        try {
            returnValue = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        msDuration = System.currentTimeMillis() - msDuration;
        System.out.println("Duration of function " + joinPoint.getSignature().getName() + " is " + msDuration + "ms");

        return returnValue;
    }

}
