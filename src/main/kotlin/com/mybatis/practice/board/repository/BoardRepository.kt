package com.mybatis.practice.board.repository

import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface BoardRepository {
    fun insertBoard(title: String, content: String, createdTime: LocalDateTime)
}

