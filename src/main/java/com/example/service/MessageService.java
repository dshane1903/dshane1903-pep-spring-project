package com.example.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.example.entity.*;
import com.example.repository.*;
import com.example.exception.*;

@Service
public class MessageService {

    MessageRepository messageRepository; 

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message newMessage) throws MessageTooLongException, MessageIsBlankException, PosterDoesNotExistException {
        if (newMessage.getMessageText().length() > 255) {
            throw new MessageTooLongException("This message is too long enough and could not be created.");
        }
        if (newMessage.getMessageText().isBlank()) {
            throw new MessageIsBlankException("This message is blank and could not be created.");
        }
        if (!messageRepository.findById(newMessage.getPostedBy()).isPresent()) {
            throw new PosterDoesNotExistException("The account that posted this message does not exist.");
        }
        return messageRepository.save(newMessage);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(int messageId) throws MessageDoesNotExistException {
        return messageRepository.findById(messageId).orElseThrow(
            () -> new MessageDoesNotExistException("This message does not exist and could not be found."));
    }

    public void deleteMessageById(int messageId) throws MessageDoesNotExistException {
        messageRepository.findById(messageId).orElseThrow(
            () -> new MessageDoesNotExistException("This message does not exist and could not be found."));
        messageRepository.deleteById(messageId);
    }

    public void updateMessageById(int messageId, String messageText) throws MessageDoesNotExistException, MessageIsBlankException, MessageTooLongException {
        Message message = messageRepository.findById(messageId).orElseThrow(
            () -> new MessageDoesNotExistException("This message does not exist and could not be found."));
        if (messageText.isBlank()) {
            throw new MessageIsBlankException("This message is blank and cannot be used for updating.");
        } else if (messageText.length() > 255) {
            throw new MessageTooLongException("This message is too long and cannot be used for updating.");
        } else {
            message.setMessageText(messageText);
            messageRepository.save(message);
        }
    }

    public List<Message> getAllMessagesById(int messageId) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(messageId);
        return messageRepository.findAllById(array);
    }        
};
