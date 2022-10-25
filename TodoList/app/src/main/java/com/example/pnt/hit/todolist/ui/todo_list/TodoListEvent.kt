package com.example.pnt.hit.todolist.ui.todo_list

import com.example.pnt.hit.todolist.data.Todo

sealed class TodoListEvent {
    data class DeleteTodoClick(
        val todo: Todo
    ) : TodoListEvent()

    data class OnDoneChange(
        val todo: Todo,
        val isDone: Boolean
    ) : TodoListEvent()

    object OnUndoDeleteClick: TodoListEvent()
    data class OnTodoClick(
        val todo: Todo
    ) : TodoListEvent()

    object OnAddTodoClick : TodoListEvent()

}
