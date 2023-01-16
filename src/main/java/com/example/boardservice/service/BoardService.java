package com.example.boardservice.service;


import com.example.boardservice.Entity.Board;
import com.example.boardservice.dto.BoardDto;
import com.example.boardservice.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    private final ModelMapper modelMapper;


    //수정 및 글쓰기
    @Transactional
    public long savePost(BoardDto boardDto) {

        return boardRepository.save(boardDto.toEntity()).getId();
    }

    //리스트 형태로 조회
    @Transactional(readOnly = true)
    public List<BoardDto> getBoardList(){

        return boardRepository.findAll()
                .stream()
                .map(board->modelMapper.map(board,BoardDto.class))
                .collect(Collectors.toList());
    }


    //단건조회
    @Transactional(readOnly = true)
    public BoardDto getBoardList(long no){

        Optional<Board> BoardList = boardRepository.findById(no);
        Board board = BoardList.get();

        BoardDto boardDto=BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .createdDate(board.getCreatedDate())
                .build();

        return boardDto;



    }

    //글 삭제
    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }
}
