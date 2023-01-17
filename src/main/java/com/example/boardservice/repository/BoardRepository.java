package com.example.boardservice.repository;

import com.example.boardservice.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {

    List<Board> findByTitleContaining(String keyword);
}
