package com.SpringBoot.chatBot.AIChat.controller;


import com.SpringBoot.chatBot.AIChat.dto.Request;
import com.SpringBoot.chatBot.AIChat.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
public class Controller {


    @Autowired
    private RestTemplate chatBotRestTemplate;

    @Value("${model}")
    private String model;

    @Value("${api.url}")
    private String apiUrl;

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody String prompt) {

        Request request = new Request(model, prompt);


        Response response = chatBotRestTemplate.postForObject(apiUrl, request, Response.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return new ResponseEntity<>("No response form api", HttpStatus.NO_CONTENT);
        }


        return new ResponseEntity<>(response.getChoices().get(0).getMessage().getContent(), HttpStatus.OK);
    }
}
