package ch.rasc.ssespring;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import ch.rasc.sse.eventbus.SseEvent;
import ch.rasc.sse.eventbus.SseEventBus;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin
public class SseController {

	private final SseEventBus eventBus;

	public SseController(SseEventBus eventBus) {
		this.eventBus = eventBus;
	}

	@GetMapping("/register/{id}")
	public SseEmitter register(@PathVariable("id") String id, HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-store");
		return this.eventBus.createSseEmitter(id, 30_000L, SseEvent.DEFAULT_EVENT, "dto");
	}

}
