package com.icia.board;

import com.icia.board.dto.BoardSaveDTO;
import com.icia.board.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class BoardTest {
    @Autowired
    private BoardService bs;

    @Test
    @DisplayName("글쓰기데이터생성")
    public void newBoard() {
        // IntStream을 이용하여 새글 30개 DB에 저장해 놓기.
        IntStream.rangeClosed(1, 30).forEach(i ->{
            bs.save(new BoardSaveDTO("Writer"+i, "Password"+i, "Title"+i, "Contents"+i));
        });
    }
}


