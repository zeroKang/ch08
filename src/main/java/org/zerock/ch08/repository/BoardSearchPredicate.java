package org.zerock.ch08.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.zerock.ch08.dto.SearchDTO;
import org.zerock.ch08.entity.QBoard;


public class BoardSearchPredicate {

    public static Predicate search(SearchDTO dto) {

        QBoard qBoard = QBoard.board;


        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if(dto.getType() == null){
            return booleanBuilder;
        }

        String type = dto.getType();
        String keyword = dto.getKeyword();

        if(type.equals("t")){
            booleanBuilder.and(qBoard.title.contains(keyword));
        }

        return booleanBuilder;

    }
}