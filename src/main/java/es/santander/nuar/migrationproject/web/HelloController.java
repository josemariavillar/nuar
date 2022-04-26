package es.santander.nuar.migrationproject.web;

import es.santander.nuar.async.AsyncExceptionHandler;
import es.santander.nuar.async.NuarAsyncProperties;
import es.santander.nuar.async.NuarRejectedExecutionHandler;
import es.santander.nuar.async.NuarTaskDecorator;
import es.santander.nuar.util.authorization.annotation.types.OperationType;
import es.santander.nuar.util.authorization.annotation.types.Scope;
import es.santander.nuar.util.common.context.NuarContext;
import es.santander.nuar.util.common.context.NuarContextHolder;
import es.santander.nuar.util.common.omnichannel.ContactPoint;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;

@RestController
@RequestMapping("/hello")
public class HelloController {

	Scope scope;

	OperationType operationType;

	@GetMapping("/get-contactpoint")
	public ContactPoint getDarwinContactPoint() {
		NuarContext context = NuarContextHolder.getCurrentContext();
		return context.getContactPoint();
	}

	NuarAsyncProperties asyncProperties;

	private static Executor getDarwinDefaultExecutor(NuarAsyncProperties properties) {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(properties.getCorePoolSize());
		threadPoolTaskExecutor.setMaxPoolSize(properties.getMaxPoolSize());
		threadPoolTaskExecutor.setQueueCapacity(properties.getQueueCapacity());
		threadPoolTaskExecutor.setTaskDecorator(new NuarTaskDecorator());
		threadPoolTaskExecutor.setAwaitTerminationSeconds(properties.getAwaitTerminationSeconds());
		threadPoolTaskExecutor.setKeepAliveSeconds(properties.getKeepAliveSeconds());
		threadPoolTaskExecutor.setRejectedExecutionHandler(new NuarRejectedExecutionHandler());
		threadPoolTaskExecutor.setThreadNamePrefix("MyAppThreadPrefix");

		return threadPoolTaskExecutor;
	}

	private AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new AsyncExceptionHandler();
	}

}