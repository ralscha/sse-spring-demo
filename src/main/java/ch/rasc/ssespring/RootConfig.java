package ch.rasc.ssespring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.rasc.sse.eventbus.config.EnableSseEventBus;

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
