package com.example.controller;

//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.service.*;
import com.example.entity.*;
import com.example.exception.*;
import java.util.*;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

@RestController
public class SocialMediaController {

    AccountService accountService;
    MessageService messageService;

    public SocialMediaController(AccountService accountService, MessageService messageService) {
        this.accountService = accountService;
        this.messageService = messageService;
    }

    @PostMapping("register")
    public ResponseEntity<Account> register(@RequestBody Account account) {
        try {
            return ResponseEntity.status(200).body(accountService.register(account));
        } catch (DuplicateUsernameException du) {
            return ResponseEntity.status(409).body(account);
        } catch (AccountIsNullException ac) {
            return ResponseEntity.status(400).body(account);
        } catch (UsernameIsBlankException us) {
            return ResponseEntity.status(400).body(account);
        } catch (PasswordNotLongEnoughException pa) {
            return ResponseEntity.status(400).body(account);
        }
    }

    //problem
    @PostMapping("login")
    public ResponseEntity<Account> login(@RequestBody Account account) {
        try {
            return ResponseEntity.status(200).body(accountService.login(account.getUsername(), account.getPassword()));
        } catch (IncorrectLoginException in) {
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("messages")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        try {
        return ResponseEntity.status(200).body(messageService.createMessage(message));
        } catch (MessageTooLongException mt) {
            return ResponseEntity.status(400).body(message);
        } catch (MessageIsBlankException mi) {
            return ResponseEntity.status(400).body(message);
        } catch (PosterDoesNotExistException po) {
            return ResponseEntity.status(400).body(message);
        }
    }

    //problem 
    @GetMapping("messages")
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.status(200).body(messageService.getAllMessages());
    }

    @GetMapping("/messages/{message_id}")
    public ResponseEntity<Message> getOneMessage(@PathVariable("message_id") Integer messageId) {
        try { 
            return ResponseEntity.status(200).body(messageService.getMessageById(messageId));
        } catch (MessageDoesNotExistException me) {
            return ResponseEntity.status(200).body(null);
        }
    }
    /// problem
    @DeleteMapping("/messages/{message_id}")
    public ResponseEntity<Integer> deleteMessage(@PathVariable("message_id") Integer messageId) {
        try {
            messageService.deleteMessageById(messageId);
            return ResponseEntity.ok().body(1);
        } catch (MessageDoesNotExistException md) {
            return ResponseEntity.ok().build();
        }
    }
    //problem
    @PatchMapping("messages/{message_id}")
    public ResponseEntity<Integer> updateMessage(@PathVariable("message_id") Integer messageId, @RequestBody Message message) {
        try {
            messageService.updateMessageById(messageId, message.getMessageText());
            return ResponseEntity.status(200).body(1);
        } catch (MessageDoesNotExistException md) {
            return ResponseEntity.status(400).body(null);
        } catch (MessageIsBlankException mi) {
            return ResponseEntity.status(400).body(null);
        } catch (MessageTooLongException mt) {
            return ResponseEntity.status(400).body(null);
        }
    }

    //problem
    @GetMapping("accounts/{account_id}/messages")
    public ResponseEntity<List<Message>> getAllMessagesById(@PathVariable("account_id") Integer account_id) {
        return ResponseEntity.status(200).body(messageService.getAllMessagesById(account_id));
    }
}
