package spring.sample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class AspectInterceptor {

    @Before("execution(public * spring.sample.aop..*(..))")
    public void invokeBefore(JoinPoint joinPoint) {
        System.out.printf("[AOP at before](メソッド実行前) 引数:%s, クラス: %s#, メソッド:%s%n",
                Arrays.toString(joinPoint.getArgs()),
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName());
    }

    @Around("execution(public * spring.sample.aop..*(..))")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object ret = null;
        try {
            System.out.printf("[AOP at around](メソッド呼び出し前) 引数:%s, クラス: %s#, メソッド:%s%n",
                    Arrays.toString(proceedingJoinPoint.getArgs()),
                    proceedingJoinPoint.getTarget().getClass(),
                    proceedingJoinPoint.getSignature().getName());

            ret = proceedingJoinPoint.proceed();
            return ret;
        } finally {
            System.out.printf("[AOP at around](メソッド呼び出し後) 引数:%s, クラス: %s#, メソッド:%s%n",
                    ret,
                    proceedingJoinPoint.getTarget().getClass(),
                    proceedingJoinPoint.getSignature().getName());
        }
    }
}
