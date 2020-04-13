package org.zerock.ch08.service;

import org.springframework.data.domain.Pageable;
import org.zerock.ch08.dto.BoardDTO;
import org.zerock.ch08.dto.PageResultDTO;
import org.zerock.ch08.entity.Board;

public interface BoardService {

    void register(BoardDTO boardDTO);

    PageResultDTO<Board, BoardDTO> getList(Pageable pageable);

    BoardDTO getBoard(Long bno);

}
