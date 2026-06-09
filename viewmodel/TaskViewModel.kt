class TaskViewModel(
    private val repository: TaskRepository
) : ViewModel() {

    val tasks = repository.getTasks()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            emptyList()
        )

    fun addTask(title: String, description: String) {

        viewModelScope.launch {

            repository.insert(
                Task(
                    title = title,
                    description = description
                )
            )
        }
    }
    fun toggleTask(task: Task) {

        viewModelScope.launch {

            repository.update(
                task.copy(
                    completed = !task.completed
                )
            )
        }
    }

    fun deleteTask(task: Task) {

        viewModelScope.launch {
            repository.delete(task)
        }
    }
}
