namespace task_manager_frontend;

public class TaskItem
{
    // The '?' makes it a nullable long. Now it defaults to null!
    public long? Id { get; set; } 
    
    public string Title { get; set; } = string.Empty;
    public string? Description { get; set; }
    
    // Ensure this is uppercase to match your Java Enum exactly
    public string Status { get; set; } = "TODO";
}