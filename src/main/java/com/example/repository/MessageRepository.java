package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.example.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>, CrudRepository<Message, Integer> {

    
}
