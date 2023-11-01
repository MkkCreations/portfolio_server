package com.mkkcreations.portfolio_server.api.service;

import com.mkkcreations.portfolio_server.api.model.Log;
import com.mkkcreations.portfolio_server.api.model.Message;
import com.mkkcreations.portfolio_server.api.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    LogService logService;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(String id) {
        return messageRepository.findById(id).orElse(null);
    }

    public Message createMessage(Message message) {
        Message newMessage = messageRepository.save(message);
        logService.createLog(
                "Message",
                String.format("%s send message", message.getName()),
                Map.of("name", message.getName(),  "message", message.getMessage()));
        return newMessage;
    }

    public Message updateMessage(Message message) {
        return messageRepository.save(message);
    }

    public void deleteMessage(String id) {
        messageRepository.deleteById(id);
        logService.createLog("Message", String.format("Message with id %s deleted", id), null);
    }
}
