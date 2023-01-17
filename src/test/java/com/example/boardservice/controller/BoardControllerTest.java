package com.example.boardservice.controller;

import com.example.boardservice.Entity.Board;
import com.example.boardservice.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardControllerTest {

    @Autowired
    private BoardRepository boardRepository;
    @Test
    public void test(Pageable pageable) throws Exception{

        boardRepository.save(new Board("1","1,","1"));

        Page<Board> board = boardRepository.findAll(pageable);

        for(Board b:board){
            System.out.println("board="+b);
        }


    }
}