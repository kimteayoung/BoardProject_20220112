package com.icia.board.service;

import com.icia.board.dto.BoardDetailDTO;
import com.icia.board.dto.BoardSaveDTO;
import com.icia.board.entity.BoardEntity;
import com.icia.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository br;

    @Override
    public Long save(BoardSaveDTO boardSaveDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveBoard(boardSaveDTO);
        return br.save(boardEntity).getId();
    }

    @Override
    public List<BoardDetailDTO> findAll() {
        List<BoardEntity> boardEntityList = br.findAll();
        List<BoardDetailDTO> boardList = new ArrayList<>();
        for (BoardEntity boardEntity: boardEntityList) {
            boardList.add(BoardDetailDTO.toBoardDetailDTO(boardEntity));
        }
        return boardList;
    }

    @Override
    public BoardDetailDTO findById(Long boardId) {
        Optional<BoardEntity> optionalBoardEntity = br.findById(boardId);
        /*
            Optional 객체 메서드
            - isPresent(): 데이터가 있으면 true, 없으면 false 반환
            - isEmpty(): 데이터가 없으면 true, 있으면 false 반환
            - get(): Optional 객체에 들어있는 실제 데이터를 가져올 때
         */
        BoardDetailDTO boardDetailDTO = null;
        if (optionalBoardEntity.isPresent()) {
            BoardEntity boardEntity = optionalBoardEntity.get();
            boardDetailDTO = BoardDetailDTO.toBoardDetailDTO(boardEntity);
        }
        return boardDetailDTO;
    }


}
