package create.view;

import create.controller.ProjectController;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectPanel extends JPanel
{
	private ProjectController baseController;
	private SpringLayout baseLayout;
	private JTextArea textArea;
	private JButton firstButton;
	private JTextField textField;
	
	public ProjectPanel(ProjectController baseController)
	{
		super();
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		textArea = new JTextArea(5, 25);
		firstButton = new JButton("Guess!");
		textField = new JTextField(25);
			
		setupLayout();
		setupPanel();
		setupListeners();
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, textArea, 72, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, textArea, -154, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, textArea);
		baseLayout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, textArea);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 175, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 6, SpringLayout.SOUTH, textField);
		baseLayout.putConstraint(SpringLayout.SOUTH, textField, -113, SpringLayout.SOUTH, this);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		this.add(textArea);
		this.add(firstButton);
		this.add(textField);
		
		textArea.setEditable(false);
		textArea.setEnabled(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
	}
	
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userGuess = textField.getText();
				String botResponse = baseController.useChatbotCheckers(userGuess);
				
				textArea.setText("You guessed: " + userGuess + "\n" + "The computer guessed: " + botResponse);
				textField.setText("");
			}
		});
	}
	
	
	
}
