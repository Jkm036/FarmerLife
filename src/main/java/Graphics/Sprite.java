package Graphics;

import Graphics.Tiles.Tile;
import Main.Game;

public class Sprite {
public int pixels[];
public int size=Game.SIZE;
public int width, height;

	Sprite(int xCoord, int yCoord,SpriteSheet sheet){
		pixels=new int[size*size];
		this.width=size;
		this.height=size;
		this.loadSprite(xCoord,yCoord,sheet);	
	}
	Sprite(int width, int height, int xCoord, int yCoord,SpriteSheet sheet){
		this.width=width;
		this.height=height;
		pixels=new int[width*height];
		this.loadSprite(width,height,xCoord,yCoord,sheet);	
	}
	private void loadSprite(int width, int height, int xCoord,int yCoord, SpriteSheet sheet) {
		for(int y=0;y<height;y++) {
			for(int x =0;x<width;x++) {
				pixels[x+(y*width)]=sheet.pixels[((xCoord*size)+x)+((yCoord*size)+y)*sheet.width];
			}
		}
	}
	private void loadSprite(int xCoord,int yCoord, SpriteSheet sheet) {
		for(int y=0;y<size;y++) {
			for(int x =0;x<size;x++) {
				pixels[x+(y*size)]=sheet.pixels[((xCoord*size)+x)+((yCoord*size)+y)*sheet.width];
			}
		}
	}
	
	public static Sprite getSprite(int tile_code) {
		if(tile_code==Tile.grass_col) {
			return grass;
		}else if (tile_code == Tile.home_one_col){
			return home_one;
		}else if (tile_code == Tile.dark_dead_grass_col){
			return dead_grass_dark;
		}else if(tile_code == Tile.dark_dead_grass_one_col) {
			return dead_grass_dark_one;
		}else if(tile_code == Tile.wheat_one_col) {
			return wheat_one;
		}else if(tile_code == Tile.wheat_two_col) {
			return wheat_two;
		}else if(tile_code == Tile.wheat_three_col) {
			return wheat_three;
		}else if(tile_code == Tile.wheat_four_col) {
			return wheat_four;
		}else {
			return water;
		}
	}
	//inventory
	public static Sprite inventory =           new Sprite(SpriteSheet.inventory.width,SpriteSheet.inventory.height,
												0,0,SpriteSheet.inventory);
	//environment
	public static Sprite grass =               new Sprite(2,0,SpriteSheet.grass);
	public static Sprite home_one =            new Sprite(0,1,SpriteSheet.houses);
	public static Sprite water =               new Sprite(4,0,SpriteSheet.shore);
	public static Sprite dead_grass_dark =     new Sprite (0,0, SpriteSheet.deadGrass);
	public static Sprite dead_grass_dark_one = new Sprite (1,0, SpriteSheet.deadGrass);
	public static Sprite wheat_one =           new Sprite (0,0, SpriteSheet.wheatField);
	public static Sprite wheat_two =           new Sprite (1,0, SpriteSheet.wheatField);
	public static Sprite wheat_three =         new Sprite (2,0, SpriteSheet.wheatField);
	public static Sprite wheat_four =          new Sprite (3,0, SpriteSheet.wheatField);
	// player sprites 
	public static Sprite player_f= new Sprite(0,0,SpriteSheet.player);
	public static Sprite player_up1= new Sprite(2,1,SpriteSheet.player);
	public static Sprite player_up2= new Sprite(4,1,SpriteSheet.player);
	public static Sprite player_right1= new Sprite(2,2,SpriteSheet.player);
	public static Sprite player_right2= new Sprite(4,2,SpriteSheet.player);
	public static Sprite player_left1= new Sprite(2,3,SpriteSheet.player);
	public static Sprite player_left2= new Sprite(4,3,SpriteSheet.player);
	public static Sprite player_down1= new Sprite(2,4,SpriteSheet.player);
	public static Sprite player_down2= new Sprite(4,4,SpriteSheet.player);
	//Mob sprites 
		//Mammoth
	public static Sprite mammoth_f= new Sprite(0,2,SpriteSheet.mammoth);
	public static Sprite mammoth_right1= new Sprite(1,0,SpriteSheet.mammoth);
	public static Sprite mammoth_right2= new Sprite(3,0,SpriteSheet.mammoth);
	public static Sprite mammoth_left1= new Sprite(1,1,SpriteSheet.mammoth);
	public static Sprite mammoth_left2= new Sprite(3,1,SpriteSheet.mammoth);	
	public static Sprite mammoth_down1= new Sprite(1,2,SpriteSheet.mammoth);
	public static Sprite mammoth_down2= new Sprite(3,2,SpriteSheet.mammoth);
	public static Sprite mammoth_up1= new Sprite(1,3,SpriteSheet.mammoth);
	public static Sprite mammoth_up2= new Sprite(3,3,SpriteSheet.mammoth);
		//Bjorg //down,up,left,right 2 4
	public static Sprite bjorg_f= new Sprite(1,0,SpriteSheet.bjorg);
	public static Sprite bjorg_down1= new Sprite(2,0,SpriteSheet.bjorg);
	public static Sprite bjorg_down2= new Sprite(4,0,SpriteSheet.bjorg);
	public static Sprite bjorg_up1= new Sprite(2,1,SpriteSheet.bjorg);
	public static Sprite bjorg_up2= new Sprite(4,1,SpriteSheet.bjorg);
	public static Sprite bjorg_left1= new Sprite(2,2,SpriteSheet.bjorg);
	public static Sprite bjorg_left2= new Sprite(4,2,SpriteSheet.bjorg);	
	public static Sprite bjorg_right1= new Sprite(2,3,SpriteSheet.bjorg);
	public static Sprite bjorg_right2= new Sprite(4,3,SpriteSheet.bjorg);
	
	
	
	
	
}

