package com.mybatis.practice.board.entity

import java.time.LocalDateTime


data class Board(
    val id: Long = 0,
    val title: String,
    val content: String,
    val createdTime: LocalDateTime
)