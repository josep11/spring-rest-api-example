package com.freseniuskabi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleServiceAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(SampleServiceAspect.class);

	@Before("execution(* com.freseniuskabi.service.PacienteService.findById (java.lang.Long)) && args(id)")
	public void beforeFindingPaciente(Long id) {

		LOGGER.info("A request was issued for a sample id: " + id);
	}

	@AfterReturning(value = "execution(* com.freseniuskabi.service.PacienteService.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		LOGGER.info("{} returned with value {}", joinPoint, result);
	}

	// @After("execution(* com.freseniuskabi.service.PacienteService.findById (..))")
	// public void after(JoinPoint joinPoint) {
	// LOGGER.info("after execution of {}", joinPoint);
	// }

	// @AfterThrowing(value = "execution(* com.freseniuskabi.service.PacienteService.findById (..))", throwing = "ex")
	// public void afterThrowing(Exception ex) {
	// LOGGER.info("after throwing ", ex);
	// }

}