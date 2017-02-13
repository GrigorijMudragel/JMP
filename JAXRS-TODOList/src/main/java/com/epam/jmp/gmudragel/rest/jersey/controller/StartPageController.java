package com.epam.jmp.gmudragel.rest.jersey.controller;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class StartPageController {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<html>"+
	  "<head>"+
	  "  <title>ToDoList App</title>"+
	 " </head>"+
	 " <body bgcolor=white>"+
	 "  <p> Grigorij Mudragel</p>" +
	 " <p>Create a console program for managing \"TODO\" list.</p>" +
	 "<p>Requirements:</p>" +
	 "<p>- the following commads should be supported: add new task, show all taks, remove specific task, remove all tasks</p>" +
	 "<p>- storage for tasks should be text file</p>" +
	 "<p>- exceptions and incorrect input should be hadled properly </p>" +
	 "<p>Implementation as REST service</p>"+
	 "<p>Available methods:</p>"+
	 "<p>GET JAXRS-TODOList/rest/tasks - show all tasks</p>"+
	 "<p>POST JAXRS-TODOList/rest/tasks/{task name} - add new task</p>"+
	 "<p>DELETE JAXRS-TODOList/rest/tasks/{task name} - remove specific task by name</p>"+
	 "<p>DELETE JAXRS-TODOList/rest/tasks - remove all tasks</p>"+
		"</body>"+
	"</html>";
	
	}

}