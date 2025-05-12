package com.mybatis.practice.board.repository

import org.apache.ibatis.annotations.Mapper
import java.time.LocalDateTime

@Mapper
interface BoardRepository {
    fun insertBoard(title: String, content: String, createdTime: LocalDateTime)
}

