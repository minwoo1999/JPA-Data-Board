package com.example.boardservice.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name = "board")
public class Board extends TimeEntity{ //board클래스가 timeentity클래스를 상속받음

    @Id @GeneratedValue
    private Long id;

    @Column(length =10)
    private String writer;

    @Column(length=100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Builder
    public Board(Long id, String writer, String title, String content) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}
