package edu.miu.spring.boot.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Logger {
    @Id
    private long transactionId;
    private LocalDate date;
    private LocalTime time;
    private String principle;
    private String operation;
}
