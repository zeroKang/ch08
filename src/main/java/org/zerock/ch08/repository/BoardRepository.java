package org.zerock.ch08.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.ch08.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
