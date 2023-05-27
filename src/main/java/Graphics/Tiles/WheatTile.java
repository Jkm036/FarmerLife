package Graphics.Tiles;

import Graphics.Sprite;
import Graphics.World;

public class WheatTile extends Tile {
short type;
private short health;
private static short WHEAT_HEALTH= 15; 
	public WheatTile(Sprite sprite,short type) {
		super(sprite);
		this.solid=false;
		this.type=type;
		// TODO Auto-generated constructor stub
	}
	public void increment_health() {
		health++;
		if(health>= 15 && type!= 4)
			evolve();
	}
	private void evolve() {
		int worldX= this.xPos/16;
		int worldY= this.yPos/16;
		health=0;
		switch(this.type) {
		case 1:
			type++;
			this.sprite=Sprite.wheat_two;
			World.foreground[worldX +(worldY*World.MAP_WIDTH)]=Tile.wheat_two_col;
			return;
		case 2:
			type++;
			this.sprite=Sprite.wheat_three;
			World.foreground[worldX +(worldY*World.MAP_WIDTH)]=Tile.wheat_three_col;
			return;
		case 3:
			type++;
			this.sprite=Sprite.wheat_four;
			World.foreground[worldX +(worldY*World.MAP_WIDTH)]=Tile.wheat_four_col;
			return;
		}
	}
}
