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
    var author: String,

    @Column(name = "title")
    var title: String,

    @Column(name = "content")
    var content: String,
) {
    @CreatedDate
    @Column(name = "create_date", nullable = false, updatable = false)
    var createDate: Date? = Date()

    @LastModifiedDate
    @Column(name = "update_date", nullable = false)
    var updateDate: Date = Date()
}
