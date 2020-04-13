package org.zerock.ch08.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.ch08.dto.BoardDTO;
import org.zerock.ch08.dto.PageResultDTO;
import org.zerock.ch08.entity.Board;
import org.zerock.ch08.repository.BoardRepository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.function.Function;

@Service
@Transactional
@Log4j2
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;


    @Override
    public void register(BoardDTO boardDTO) {

        Board board = convertDTOToEntity(boardDTO);
        log.info(board);

        boardRepository.save(board);

    }

    @Override
    public PageResultDTO<Board, BoardDTO> getList(Pageable pageable) {

        Page<Board> result = boardRepository.findAll(pageable);

        Function<Board, BoardDTO> fn = (Board e) -> {
            return BoardDTO.builder().bno(e.getBno())
                    .title(e.getTitle())
                    .writer(e.getWriter())
                    .regdate(e.getRegDate())
                    .build();
        };

        return new PageResultDTO<>(result,fn);
    }

    @Override
    public BoardDTO getBoard(Long bno) {

        Optional<Board> result = boardRepository.findById(bno);

        //없을 경우 예외 처리

        //result.get( ) -> Board -> BoardDTO로 변환
        return BoardDTO.of(result.get());

    }


    private Board convertDTOToEntity(BoardDTO boardDTO){

        return Board.builder().bno(boardDTO.getBno())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .writer(boardDTO.getWriter())
                .build();

    }

}

