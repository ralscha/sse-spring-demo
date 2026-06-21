package ch.rasc.ssespring;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ch.rasc.sse.eventbus.SseEvent;

@Service
public class DataEmitterService {

	private final ApplicationEventPublisher eventPublisher;

	public DataEmitterService(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	@Scheduled(initialDelay = 2000, fixedRate = 5_000)
	public void sendData() {
		List<Integer> values = IntStream.range(0, 5)
			.map(_ -> ThreadLocalRandom.current().nextInt(31))
			.boxed()
			.toList();
		this.eventPublisher.publishEvent(SseEvent.ofData(values));

		Dto dto = new Dto(10, "test");
		this.eventPublisher.publishEvent(SseEvent.of("dto", dto));
	}

}
