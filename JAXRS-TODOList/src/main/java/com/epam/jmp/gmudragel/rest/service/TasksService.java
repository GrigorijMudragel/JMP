package com.epam.jmp.gmudragel.rest.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TasksService {

	private List<String> tasksList = null;

	public TasksService() {
		super();
		final String FILENAME = getClass().getProtectionDomain()
				.getCodeSource().getLocation().getPath()
				+ "/ToDoList.txt";

		File f = new File(FILENAME);
		// if exist, fill list of tasks from file
		if (f.exists() && !f.isDirectory()) {
			try (BufferedReader br = new BufferedReader(new FileReader(f))) {
				tasksList = new ArrayList<String>();
				String sCurrentLine;
				while ((sCurrentLine = br.readLine()) != null) {
					tasksList.add(sCurrentLine);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			// otherwise initialize list of data and save in file
		} else {
			tasksList = new ArrayList<String>();
			tasksList.add("Fill TODO List.");
			tasksList.add("Complete tasks.");
			tasksList.add("Share it with friends.");

			saveToDoList();

		}

	}

	private void saveToDoList() {
		try {

			FileWriter fw = new FileWriter(getClass().getProtectionDomain()
					.getCodeSource().getLocation().getPath()
					+ "ToDoList.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			for (String s : tasksList) {
				bw.write(s + System.getProperty("line.separator"));
			}
			bw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getAllTasks() {
		StringBuilder sb = new StringBuilder();

		for (String s : tasksList) {
			sb.append("<p>"+s+"</p>");
		}
		return createHtmlResponse("List of tasks:" + sb.toString());

	}

	public String getTask(String taskName) {
		String task = tasksList.get(tasksList.indexOf(taskName));
		return createHtmlResponse("Task " + task + "has created");
	}

	public String addTask(String taskName) {
		if(!tasksList.contains(taskName)){
			tasksList.add(taskName);
			saveToDoList();
			return createHtmlResponse("Task " + taskName + " has added");
		}else{
			return createHtmlResponse("ToDo already contains task with such name");
		}
		
	}

	public String deleteTask(String taskName) {
		if(tasksList.contains(taskName)){
			tasksList.remove(taskName);
			saveToDoList();
			return createHtmlResponse("Task " + taskName + " was deleted");
		}else{
			return createHtmlResponse("ToDo list doesn'contain task with such name");
		}
	}

	public String deleteAllTasks() {
		if(tasksList.size()>0){
			tasksList.clear();
			saveToDoList();
			return createHtmlResponse("All tasks were deleted");
		}else{
			return createHtmlResponse("ToDo list already empty");
		}
	}

	public List<String> getTaskList() {
		return tasksList;
	}

	private String createHtmlResponse(String body) {
		return "<html>" + "<head>"
				+ "  <title>Sample Hello, World Application</title>"
				+ " </head>" + " <body bgcolor=white>" + body + " </body>"
				+ "</html>";
	}
}
