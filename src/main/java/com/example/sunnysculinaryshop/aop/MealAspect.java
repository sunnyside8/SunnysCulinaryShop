package com.example.sunnysculinaryshop.aop;

import com.example.sunnysculinaryshop.service.StatService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MealAspect {

    private final StatService statService;

    public MealAspect(StatService statService) {
        this.statService = statService;
    }

    @Pointcut("execution(* com.example.sunnysculinaryshop.web.MealController.mealPage(..))")
    public void trackMealView(){};

    @After("trackMealView()")
    public void afterAdvice(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Long mealId = (Long)args[0];

        statService.createLog(mealId);


        System.out.println();
    }
}
