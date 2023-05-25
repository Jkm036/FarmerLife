package Dialogue;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import Event.Action;
import Event.ActionListener;
import Event.KeyPressed;
import Entities.Entity;
import Main.Game;

public class DialogueBox  extends JTextField implements ActionListener {
	private String content="";
	
	private static final long serialVersionUID = 1L;

	
	
	public DialogueBox(int size){
		super(size);
		
	}
	
	public DialogueBox(String text , int size){
		super(text,size);
		this.content=text;
		
	}
	public void addText(char c) {
		content+=c;
		super.setText(content);
	}
	public void addSpace() {
		content+= " ";
		super.setText(content);
	}
	
	public void delText() {
		if(content.length()>0) {
		content=content.substring(0, content.length()-1);
		super.setText(content);
		}
	}
	public void requestResponse() {
		
	}
	public String getText() {
		return content;
	}
	public void clearText() {
		content="";
		super.setText("");
		
	}
	@Override
	public void Listen(Action a) {
		if(a instanceof KeyPressed) {
			switch (a.type){
			case ENTER:
				this.setVisible(false);
			}
		}
		
	}

}
