package com.example.board.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@Entity
data class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "author")
    val author: String,

    @Column(name = "title")
    val title: String,

    @Column(name = "content")
    val content: String,
) {

    @CreatedDate
    var createDate: Date = Date()

    @LastModifiedDate
    var updateDate: Date = Date()
}
