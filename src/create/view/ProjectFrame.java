package create.view;

import javax.swing.JFrame;
import create.controller.ProjectController;
import java.awt.Dimension;


public class ProjectFrame extends JFrame
{
	private ProjectController baseController;
	private ProjectPanel basePanel;
	
	public ProjectFrame(ProjectController baseController)
	{
		super();
		this.baseController = baseController;
		basePanel = new ProjectPanel(baseController);
		
		setupFrame();
	}
	
	//Sets the parameters for the frame
	private void setupFrame()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(basePanel);
		this.setTitle("Guessing Game");
		this.setSize(new Dimension(600, 400));
		this.setResizable(false);
		this.setVisible(true);
		
	}
}
