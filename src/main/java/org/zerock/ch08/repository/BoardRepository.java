package org.zerock.ch08.repository;

import com.querydsl.core.BooleanBuilder;
import lombok.extern.log4j.Log4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.zerock.ch08.entity.Board;
import org.zerock.ch08.entity.QBoard;


public interface BoardRepository extends JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board> {

}
