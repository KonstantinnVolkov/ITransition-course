package com.example.task4.service;

import com.example.task4.entities.Message;
import com.example.task4.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getProfileMessage(String receiverName, String senderName) {
        List<Message> messages = messageRepository.findByReceiverAndSender(receiverName, senderName);
        return messages;
    }

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }
}
