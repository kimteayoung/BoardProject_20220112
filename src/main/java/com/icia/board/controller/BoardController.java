package com.icia.board.controller;

import com.icia.board.dto.BoardDetailDTO;
import com.icia.board.dto.BoardSaveDTO;
import com.icia.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    private final BoardService bs;

    @GetMapping("/save")
    public String saveForm() {
        return "board/save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardSaveDTO boardSaveDTO){
        Long boardId = bs.save(boardSaveDTO);
        return "redirect:/board/";
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<BoardDetailDTO> boardList = bs.findAll();
        model.addAttribute("boardList", boardList);
        log.info("findAll 호출");
        return "board/findAll";
    }

    @GetMapping("/{boardId}")
    public String findById(Model model, @PathVariable Long boardId) {
        log.info("글보기 메서드 호출. 요청글 번호: {}", boardId);
        BoardDetailDTO board = bs.findById(boardId);
        model.addAttribute("board", board);
        return "board/findById";
    }



}
