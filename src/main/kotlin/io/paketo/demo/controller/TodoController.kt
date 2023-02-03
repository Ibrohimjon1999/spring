package io.paketo.demo.controller

import io.paketo.demo.entity.TodoModel
import io.paketo.demo.repository.ToDoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/todo")
class TodoController(@Autowired val toDoRepository: ToDoRepository){

    @GetMapping("/get-all")
    fun getAll():List<TodoModel>{
        return toDoRepository.findAll();
    }

    @PostMapping("/save")
    fun save(@RequestBody todoModel: TodoModel){
        toDoRepository.save(todoModel)
    }

    @PutMapping("/update")
    fun update(@RequestBody todoModel: TodoModel){
        todoModel.getTask()?.let { todoModel.getId()?.let { it1 -> toDoRepository.update(it, it1) } }
    }
}