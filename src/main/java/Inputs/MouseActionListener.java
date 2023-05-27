package Inputs;

import java.awt.event.MouseMotionListener;

import Event.ActionListener;
import Event.MouseMoved;
import Event.MousePressed;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseActionListener implements MouseListener, MouseMotionListener {
ActionListener listener;
	

	public MouseActionListener(ActionListener listener) {
		this.listener=listener;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		listener.Listen(new MouseMoved(e.getX(), e.getY(), true));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		listener.Listen(new MouseMoved(e.getX(), e.getY(), false));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		listener.Listen(new MousePressed(e.getX(),e.getY() ));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
