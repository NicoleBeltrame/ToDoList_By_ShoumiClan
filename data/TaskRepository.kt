class TaskRepository(
    private val dao: TaskDao
) {

    fun getTasks() = dao.getAllTasks()

    suspend fun insert(task: Task) {
        dao.insert(task)
    }

    suspend fun update(task: Task) {
        dao.update(task)
    }

    suspend fun delete(task: Task) {
        dao.delete(task)
    }
}
