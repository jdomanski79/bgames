package pl.jdomanski.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

	
	@MessageMapping("/game")
	@SendTo("/topic/games")
	public String hello(String message) {
		return "message accepted" + message;
	}
}
