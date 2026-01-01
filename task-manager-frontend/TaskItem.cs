namespace task_manager_frontend;

public class TaskItem
{
    public long? Id { get; set; } 
    public string Title { get; set; } = string.Empty;
    public string? Description { get; set; }
    public string Status { get; set; } = "TODO";
    public int SortOrder { get; set; }
}