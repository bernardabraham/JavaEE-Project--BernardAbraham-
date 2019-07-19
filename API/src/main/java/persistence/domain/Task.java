package persistence.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;
	private int projectId;
	private String taskContent;
	public Task(int taskId, int projectId, String content) {
		super();
		this.taskId = taskId;
		this.projectId = projectId;
		this.taskContent = content;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getContent() {
		return taskContent;
	}
	public void setContent(String content) {
		this.taskContent = content;
	}
	

}
