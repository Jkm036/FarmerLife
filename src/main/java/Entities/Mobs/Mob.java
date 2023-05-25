package Entities.Mobs;

import Entities.Entity;
import Graphics.Sprite;
import Main.Game;

public class Mob extends Entity {
	protected boolean up,down,left,right;
	protected boolean moving=false;
	public int size;
	public Sprite sprite,static_sprite,up1,up2,down1,down2,right1,right2,left1,left2;
	short dir;
	

	short walking_cycle=0;
	int time=0;
	
	Mob(int xPos, int yPos){
		this.setX(xPos);
		this.setY(yPos);
	}

	@Override
	public void tick() {
		walking_cycle++;
		time++;
		if(walking_cycle>=60)
			walking_cycle=0;
		if(time>=2000)
			time=0;
		
		if(up) {
			yPos--;
			if((walking_cycle % 20)<10) {
				sprite=up1;
			}else {
				sprite=up2;
			}
		}
		if(down) {
			yPos++;
			if((walking_cycle % 20)<10) {
				sprite=down1;
			}else {
				sprite=down2;
			}
		}
		if(left) {
			xPos--;
			if(!up && !down) {
				if((walking_cycle % 20)<10) {
					sprite=left1;
				}else {
					sprite=left2;
				}
			}		
		}
		if(right) {
			xPos++;
			if(!up && !down) {
				if((walking_cycle % 20)<10) {
					sprite=right1;
				}else {
					sprite=right2;
				}
			}
					
		}
		
		if(!moving)
			sprite=static_sprite;
		
	}

	@Override
   public void render() {		
		Game.screen.render_mob(this);
	}

	

}
