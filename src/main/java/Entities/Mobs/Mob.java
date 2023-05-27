package Entities.Mobs;

import Entities.Entity;
import Graphics.Sprite;
import Graphics.World;
import Main.Game;

public class Mob extends Entity {
	protected boolean up,down,left,right;
	protected boolean moving=false;
	public int size;
	private int speed=1;
	private int dx, dy;
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
		dx=0;
		dy =0;
		
		walking_cycle++;
		time++;
		if(walking_cycle>=60)
			walking_cycle=0;
		if(time>=2000)
			time=0;
		
		if(up) {
			dy=-speed;
			if((walking_cycle % 20)<10) {
				sprite=up1;
			}else {
				sprite=up2;
			}
		}
		if(down) {
			dy=speed;
			if((walking_cycle % 20)<10) {
				sprite=down1;
			}else {
				sprite=down2;
			}
		}
		if(left) {
			dx=-speed;
			if(!up && !down) {
				if((walking_cycle % 20)<10) {
					sprite=left1;
				}else {
					sprite=left2;
				}
			}		
		}
		if(right) {
			dx=speed;
			if(!up && !down) {
				if((walking_cycle % 20)<10) {
					sprite=right1;
				}else {
					sprite=right2;
				}
			}
					
		}
		
		if(!collision(dx,dy)) {
		xPos+=dx;
		yPos+=dy;
		}
				
	}
private boolean collision (int delta_x, int delta_y) {
	for(int c=0;c< 4; c++) {
		int xt= ((xPos + dx)+ (c%2 * 8) - 4)/16;
		int yt= ((yPos + dy)+ (c/2 * 8) - 4)/16;
		if(World.getTile(xt,yt).solid)
			return true;
	}
	return false;
	
}
	@Override
   public void render() {		
		Game.screen.render_mob(this);
	}

	@Override
	public void gotHit() {
		System.out.println("ouch");
		
	}

	

}
