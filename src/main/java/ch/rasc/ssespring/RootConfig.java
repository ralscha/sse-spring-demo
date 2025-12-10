package ch.rasc.ssespring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ch.rasc.sse.eventbus.config.EnableSseEventBus;
import tools.jackson.databind.ObjectMapper;

@Configuration
@EnableWebMvc
@EnableSseEventBus
@EnableScheduling
@ComponentScan(basePackageClasses = RootConfig.class)
public class RootConfig {

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}
