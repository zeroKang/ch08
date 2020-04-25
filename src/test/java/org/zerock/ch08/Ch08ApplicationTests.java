package org.zerock.ch08;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.zerock.ch08.dto.SearchDTO;
import org.zerock.ch08.entity.Board;

import org.zerock.ch08.repository.BoardRepository;
import org.zerock.ch08.repository.BoardSearchPredicate;
import org.zerock.ch08.service.BoardService;

import java.util.Optional;

@SpringBootTest
class Ch08ApplicationTests {

	@Autowired
	private BoardRepository boardRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testQuerydsl() {

		PageRequest pageRequest = PageRequest.of(0,10);


		BooleanBuilder booleanBuilder = new BooleanBuilder();
		Page<Board> result = boardRepository.findAll(booleanBuilder,pageRequest);

		System.out.println(result);

	}

	@Test
	public void testDynamicSearch(){

		SearchDTO searchDTO = new SearchDTO();
		searchDTO.setType("t");
		searchDTO.setKeyword("123");

		BooleanBuilder booleanBuilder = new BooleanBuilder();
		boardRepository.findAll(BoardSearchPredicate.search(searchDTO));

	}

}
