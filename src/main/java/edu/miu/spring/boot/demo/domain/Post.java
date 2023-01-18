package edu.miu.spring.boot.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
}
