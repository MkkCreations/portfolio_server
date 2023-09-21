package com.mkkcreations.portfolio_server.api.rest;

import com.mkkcreations.portfolio_server.api.model.Message;
import com.mkkcreations.portfolio_server.api.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "http://localhost:3000")
public class MessageREST {
    private final MessageService messageService;

    public MessageREST(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getMessage() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable String id) {
        return messageService.getMessageById(id);
    }

    @PostMapping
    public Message addMessage(@RequestBody Message message) {
        message.setCreatedAt(new Date());
        return messageService.createMessage(message);
    }

    @PutMapping("/{id}")
    public Message updateMessage(@PathVariable String id, @RequestBody Message message) {
        return messageService.updateMessage(message);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable String id) {
        messageService.deleteMessage(id);
    }
}
