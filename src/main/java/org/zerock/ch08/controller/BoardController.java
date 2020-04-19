package org.zerock.ch08.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.ch08.dto.BoardDTO;
import org.zerock.ch08.dto.PageDTO;
import org.zerock.ch08.service.BoardService;

@Controller
@RequestMapping("/board")
@Log4j2
@AllArgsConstructor
public class BoardController {

    private BoardService boardService;

    @GetMapping("/register")
    public void registerGET(){
        log.info("registerGet.......");
    }


    @PostMapping("/register")
    public String registerPost(BoardDTO boardDTO, RedirectAttributes redirectAttributes){

        log.info(boardDTO);

        boardService.register(boardDTO);

        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public void list(
            @PageableDefault(sort = "bno", direction = Sort.Direction.DESC)
                    Pageable pageable, Model model){

        log.info("list Get.......");

        log.info("pageable: " + pageable);

        model.addAttribute("model",boardService.getList(pageable));

    }

    @GetMapping(value = {"/read","/modify"})
    public void read(@ModelAttribute("pageDTO") PageDTO pageDTO, Long bno, Model model){

        log.info("read get... or modify.. ");

        log.info("pageDTO: " + pageDTO);

        model.addAttribute("boardDTO", boardService.getBoard(bno));

    }

    @PostMapping("/remove")
    public String remove(@RequestParam(name = "bno") Long bno, RedirectAttributes redirectAttributes){

        log.info("remove " + bno);

        boardService.remove(bno);

        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/board/list";

    }

    @PostMapping("/modify")
    public String modifyPost(BoardDTO boardDTO, RedirectAttributes redirectAttributes){

        log.info("modify post.. " + boardDTO);

        boardService.modify(boardDTO);

        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/board/list";

    }


}
