package com.freseniuskabi.bgtask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

@Component
public class AppContextEventListener {

	private static final Logger log = LoggerFactory.getLogger(AppContextEventListener.class);

	@EventListener
	public void handleContextRefreshed(ContextRefreshedEvent event) {
		this.printActiveProperties((ConfigurableEnvironment) event.getApplicationContext().getEnvironment());
	}

	private void printActiveProperties(ConfigurableEnvironment env) {

		System.out.println("************************* ACTIVE APP PROPERTIES ******************************");

		List<MapPropertySource> propertySources = new ArrayList<>();

		env.getPropertySources().forEach(it -> {
			if (it instanceof MapPropertySource && it.getName().contains("applicationConfig")) {
				propertySources.add((MapPropertySource) it);
			}
		});

		propertySources.stream().map(propertySource -> propertySource.getSource().keySet()).flatMap(Collection::stream).distinct().sorted()
				.forEach(key -> {
					try {
						System.out.println(key + "=" + env.getProperty(key));
					} catch (Exception e) {
						log.warn("{} -> {}", key, e.getMessage());
					}
				});
		System.out.println("******************************************************************************");
	}
}