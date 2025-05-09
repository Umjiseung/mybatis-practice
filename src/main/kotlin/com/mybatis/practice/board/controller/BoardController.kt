package com.mybatis.practice.board.controller

import com.mybatis.practice.board.controller.dto.WriteBoardDto
import com.mybatis.practice.board.entity.Board
import com.mybatis.practice.board.service.BoardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/board")
class BoardController(
    private val boardService: BoardService,
) {

    @PostMapping
    fun writeBoard(
        @RequestBody writeBoardDto: WriteBoardDto,
    ): ResponseEntity<Board> {
        boardService.writeBoard(writeBoardDto)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

}