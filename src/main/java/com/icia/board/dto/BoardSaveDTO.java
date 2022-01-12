package com.icia.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardSaveDTO {
    private String boardWriter;
    private String boardPassword;
    private String boardTitle;
    private String boardContents;
}
