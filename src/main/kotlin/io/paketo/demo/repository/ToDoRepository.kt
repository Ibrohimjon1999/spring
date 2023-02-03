package io.paketo.demo.repository

import io.paketo.demo.entity.TodoModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface ToDoRepository :JpaRepository<TodoModel,Long>{
    @Transactional
    @Modifying
    @Query(value = "update todo_model set task=:task where id=:id", nativeQuery = true)
    fun update(@Param("task")task: String,@Param("id")id: Long)

}