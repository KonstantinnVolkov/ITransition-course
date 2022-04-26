package com.example.task4.service;

import com.example.task4.entities.Message;

import java.util.List;

public interface MessageService {

    public List<Message> getProfileMessage(String receiver, String sender);

    public void save(Message message);
}
