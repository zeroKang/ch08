package org.zerock.ch08.dto;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@ToString
public class PageResultDTO<E,D> {

    private List<D> list;

    private int currentPage;

    private int pageSize;

    private int totalPageCount;

    private boolean goPrev, goNext;

    private List<Integer> pageList;

    private int prevPage, nextPage;

    public PageResultDTO(Page<E> pageResult, Function<E,D> fn){

        //Page<E>의 각 엔티티를 DTO를 변환하고 List로 묶는 작업
        list = pageResult.getContent().stream().map(fn).collect(Collectors.toList());

        currentPage = pageResult.getNumber() +1;

        pageSize = pageResult.getSize();

        totalPageCount = pageResult.getTotalPages();

        calcPageList();

    }

    private void calcPageList(){

        int endPage = totalPageCount;
        int tempEndPage = (int)(Math.ceil(currentPage / 10.0))  * 10;
        int startPage = tempEndPage - 9;

        goPrev = startPage > 1 ;

        if(goPrev){
            prevPage = startPage - 1;
        }

        if(tempEndPage >= endPage){
            endPage = tempEndPage;
            goNext = false;
        }else {
            endPage = tempEndPage;
            goNext = true;
        }

        if(goNext){
            nextPage = endPage + 1;
        }

        //계산된 페이지 번호들을 이용해서 번호 목록 리스트
        pageList = IntStream.range(startPage, endPage + 1).boxed().collect(Collectors.toList());

    }


}
