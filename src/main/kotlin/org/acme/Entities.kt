package org.acme

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import java.time.Instant
import java.util.*
import javax.enterprise.context.ApplicationScoped
import javax.persistence.Embedded
import javax.persistence.Embeddable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

enum class CommentEventType {
    CREATED, MODIFIED, HIDDEN
}

@Embeddable
class Test {
    @Id
    var id: Long? = 1L
}

@Entity
class CommentEvent(
    val type: CommentEventType,
    @Embedded var test: Test? = Test(),
    private val instant: Instant = Instant.now()
) {

    @Id
    @GeneratedValue
    lateinit var eventUuid: UUID

}

@ApplicationScoped
class CommentEventRepo : PanacheRepository<CommentEvent>
