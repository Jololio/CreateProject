package create.controller;

import create.view.ProjectViewer;
import create.view.ProjectFrame;
import create.view.ProjectPanel;

public class ProjectController 
{
	private ProjectFrame baseFrame;
	private ProjectViewer projectView;
	
	public ProjectController()
	{
		baseFrame = new ProjectFrame(this);
		projectView = new ProjectViewer();
	}

	public void start()
	{
		String response = projectView.collectResponse("Guess a number between 1-10!");
		
		if(response.equals("10"))
		{
			projectView.displayMessage("Congratulations! You won!");
			
		}
		else
		{
			projectView.displayMessage("You are defeated...");
		}
	}
	
}
