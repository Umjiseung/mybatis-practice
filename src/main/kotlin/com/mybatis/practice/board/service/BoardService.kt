package com.mybatis.practice.board.service

import com.mybatis.practice.board.controller.dto.WriteBoardDto
import com.mybatis.practice.board.repository.BoardRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class BoardService(
    private val boardRepository: BoardRepository,
) {

    @Transactional
    fun writeBoard(writeBoardDto: WriteBoardDto) {
        boardRepository.insertBoard(writeBoardDto.title, writeBoardDto.content, LocalDateTime.now())
    }

}