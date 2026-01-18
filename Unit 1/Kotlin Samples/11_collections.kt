data class Task(val id: Int, val title: String, val completed: Boolean)

class TaskManager {
    private val tasks = mutableListOf<Task>()
    
    fun addTask(task: Task) {
        tasks.add(task)
    }
    
    fun getCompletedTasks(): List<Task> {
        return tasks.filter { it.completed }
    }
    
    fun getPendingTasks(): List<Task> {
        return tasks.filter { !it.completed }
    }
}
fun main() {
    val taskManager = TaskManager()
    
    taskManager.addTask(Task(1, "Buy groceries", false))
    taskManager.addTask(Task(2, "Clean the house", true))
    taskManager.addTask(Task(3, "Pay bills", false))
    taskManager.addTask(Task(4, "Walk the dog", true))
    
    val completedTasks = taskManager.getCompletedTasks()
    println("Completed Tasks:")
    for (task in completedTasks) {
        println("- ${task.title}")
    }
    
    val pendingTasks = taskManager.getPendingTasks()
    println("\nPending Tasks:")
    for (task in pendingTasks) {
        println("- ${task.title}")
    }
}