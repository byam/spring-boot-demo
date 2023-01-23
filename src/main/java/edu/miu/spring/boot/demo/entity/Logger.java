package edu.miu.spring.boot.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logger {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String transactionId;
    private LocalDateTime dateTime;
    private String principle;
    private String operation;
}
