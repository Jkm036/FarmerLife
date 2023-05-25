package Entities.Mobs;

import Dialogue.DialogueBox;
import Dialogue.Talkable;
import Event.Action;
import Event.ActionListener;
import Event.KeyPressed;
import Event.KeyReleased;
import Graphics.Sprite;
import Main.Game;

public class Player extends Mob implements ActionListener{
	 DialogueBox dialogue_input= Game.dialogue_input;
	 public boolean inDialogue;
	 private Talkable talkingTo = null;
	 
	 
	public Player(int xPos, int yPos){
		super(xPos,yPos);
		size=16;
		sprite=Sprite.player_f;
		static_sprite=Sprite.player_f;
		up1=Sprite.player_up1;
		up2=Sprite.player_up2;
		right1=Sprite.player_right1;
		right2=Sprite.player_right2;
		left1=Sprite.player_left1;
		left2=Sprite.player_left2;
		down1=Sprite.player_down1;
		down2=Sprite.player_down2;	
	}

	public void render() {
		Game.screen.render_player(this);
	}
	public void tick() {
		super.tick();
	}
	public void Listen(Action a) {
		//dialogue actions
		if(inDialogue) {
			up=false;
			left=false;
			right=false;
			down=false;
			Letter(a); // adds selected letter to dialogue_input box;
			return;
		}
		//outside of dialogue actions
		if(a instanceof KeyPressed) {
			switch (a.type) {
			case UP:
				up=true;
				moving=true;
				break;				
			case DOWN:
				down=true;
				moving=true;
				break;
			case LEFT:
				left=true;
				moving=true;
				break;
			case RIGHT:
				right=true;
				moving=true;
				break;
			}
		}
		if(a instanceof KeyReleased) {
			switch (a.type) {
			case UP:
				up=false;break;
			case DOWN:
				down=false;break;
			case LEFT:
				left=false;break;
			case RIGHT:
				right=false;break;
			}
			if(!up&&!down&&!right&&!left) {
				moving=false;
			}
		}
		
	}
	public void startDialogue(Talkable t) {
		this.inDialogue=true;
		talkingTo=t;
		((Character)talkingTo).inDialogue=true;
		dialogue_input.clearText();
		dialogue_input.setVisible(inDialogue);
		dialogue_input.clearText();
	}
	
	private void Letter(Action a){
		if (a instanceof KeyPressed) {
			switch(a.type) {
			 case ENTER:
				 dialogue_input.setVisible(false);
				 talkingTo.requestResponse(this, dialogue_input.getText());
				 return;
			 case UP:
				 dialogue_input.addText('w');
				 return;
			 case LEFT:
				 dialogue_input.addText('a');
				 return;
			 case RIGHT:
				 dialogue_input.addText('d');
				 return;
			 case DOWN:
				 dialogue_input.addText('s');
				 return;
			 case E:
				 dialogue_input.addText('e');
				 return;
			 case R:
				 dialogue_input.addText('r');
				 return;
			 case T:
				 dialogue_input.addText('t');
				 return;
			 case Y:
				 dialogue_input.addText('y');
				 return;
			 case U:
				 dialogue_input.addText('u');
				 return;
			 case I:
				 dialogue_input.addText('i');
				 return;
			 case O:
				 dialogue_input.addText('o');
				 return;
			 case P:
				 dialogue_input.addText('p');
				 return;
			 case F:
				 dialogue_input.addText('f');
				 return;
			 case G:
				 dialogue_input.addText('g');
				 return;
			 case H:
				 dialogue_input.addText('h');
				 return;
			 case J:
				 dialogue_input.addText('j');
				 return;
			 case K:
				 dialogue_input.addText('k');
				 return;
			 case L:
				 dialogue_input.addText('l');
				 return;
			 case Z:
				 dialogue_input.addText('z');
				 return;
			 case X:
				 dialogue_input.addText('x');
				 return;
			 case C:
				 dialogue_input.addText('c');
				 return;
			 case V:
				 dialogue_input.addText('v');
				 return;
			 case B:
				 dialogue_input.addText('b');
				 return;
			 case N:
				 dialogue_input.addText('n');
				 return;
			 case M:
				 dialogue_input.addText('m');
				 return;
			 case SPACE:
				 dialogue_input.addSpace();
				 return;
			 case DEL:
				 dialogue_input.delText();
				 return;
			default:
				 return;
			}
		}
		
	}
}
