package com.maxgideon.myrest.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ModAspect {

//    @Autowired
//    DataObject dataObject;
//
//    @Around("execution(* com.maxgideon.myrest.organization.service.OrganizationServiceImpl.getOrganizationById(long))")
//    public Object aroundGetOrganizationAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//
//        Object targetMethodResult = proceedingJoinPoint.proceed();
//        dataObject.setData(targetMethodResult);
//        return dataObject;
//    }
//
//    @Around("execution(* com.maxgideon.myrest.organization.service.OrganizationServiceImpl.getAllOrganization(*))")
//    public Object aroundGetAllOrganizationAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//
//        Object targetMethodResult = proceedingJoinPoint.proceed();
//        dataObject.setData(targetMethodResult);
//        return dataObject;
//    }
//
//    @Around("execution(* com.maxgideon.myrest.office.service.OfficeServiceImpl.getOfficeById(long))")
//    public Object aroundGetOfficeAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//
//        Object targetMethodResult = proceedingJoinPoint.proceed();
//        dataObject.setData(targetMethodResult);
//        return dataObject;
//    }
//    @Around("execution(* com.maxgideon.myrest.office.service.OfficeServiceImpl.getAllOffice(*))")
//    public Object aroundGetAllOfficeAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//
//        Object targetMethodResult = proceedingJoinPoint.proceed();
//        dataObject.setData(targetMethodResult);
//        return dataObject;
//    }
//
//    @Around("execution(* com.maxgideon.myrest.user.service.UserServiceImpl.getUserById(long))")
//    public Object aroundGetUserAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//
//        Object targetMethodResult = proceedingJoinPoint.proceed();
//        dataObject.setData(targetMethodResult);
//        return dataObject;
//    }
//    @Around("execution(* com.maxgideon.myrest.user.service.UserServiceImpl.getAllUser(*))")
//    public Object aroundGetAllUserAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//
//        Object targetMethodResult = proceedingJoinPoint.proceed();
//        dataObject.setData(targetMethodResult);
//        return dataObject;
//    }
//
//    @Around("execution(* com.maxgideon.myrest.user.service.UserServiceImpl.showAll*())")
//    public Object aroundGetAllDocumentsTypeOrCountriesAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//
//        Object targetMethodResult = proceedingJoinPoint.proceed();
//        dataObject.setData(targetMethodResult);
//        return dataObject;
//    }


}
