package com.epam.jmp.gmudragel.rest.jersey.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.epam.jmp.gmudragel.rest.service.TasksService;

@Path("/tasks")
public class TaskController {

	TasksService tasksService = new TasksService();
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getTasks() {

		return tasksService.getAllTasks();
	}

	@GET
	@Path("/{taskName}")
	@Produces(MediaType.TEXT_HTML)
	public String getTaskByName(@PathParam("taskName") String taskName) {
		return tasksService.getTask(taskName);
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	public String addTask(String taskName) {
		return tasksService.addTask(taskName);
	}

	@DELETE
	@Path("/{taskName}")
	@Produces(MediaType.TEXT_HTML)
	public String deleteTask(@PathParam("taskName") String taskName) {
		return tasksService.deleteTask(taskName);
	}
	
	@DELETE
	@Produces(MediaType.TEXT_HTML)
	public void deleteAllTasks() {
		tasksService.deleteAllTasks();
	}

}