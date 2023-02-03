package io.paketo.demo.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "todo_models")
class TodoModel : Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    @Column(name = "task")
    private val task:String? = null

    fun getId(): Long? {
        return id
    }

    fun getTask(): String? {
        return task
    }
}