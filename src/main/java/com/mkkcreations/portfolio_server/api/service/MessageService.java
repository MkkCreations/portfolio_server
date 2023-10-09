package com.mkkcreations.portfolio_server.api.service;

import com.mkkcreations.portfolio_server.api.model.Log;
import com.mkkcreations.portfolio_server.api.model.Message;
import com.mkkcreations.portfolio_server.api.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    @Autowired
    LogService logService;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(String id) {
        return messageRepository.findById(id).orElse(null);
    }

    public Message createMessage(Message message) {
        logService.createLog("Message", String.format("%s send message", message.getName()));
        return messageRepository.save(message);
    }

    public Message updateMessage(Message message) {
        return messageRepository.save(message);
    }

    public void deleteMessage(String id) {
        messageRepository.deleteById(id);
    }
}
