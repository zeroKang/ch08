package org.zerock.ch08.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zerock.ch08.entity.Board;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class BoardDTO {

    private Long bno;

    private String title, content, writer;

    private LocalDateTime regdate, modDate;

    public static BoardDTO of(Board board){

        BoardDTO dto = new BoardDTO();
        dto.setBno(board.getBno());
        dto.setTitle(board.getTitle());
        dto.setContent(board.getContent());
        dto.setWriter(board.getWriter());
        dto.setRegdate(board.getRegDate());
        dto.setModDate(board.getModDate());

        return dto;
    }

}
