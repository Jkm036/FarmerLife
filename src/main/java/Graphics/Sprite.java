package Graphics;

import Main.Game;

public class Sprite {
public int pixels[];
public int size=Game.SIZE;

	Sprite(int xCoord, int yCoord,SpriteSheet sheet){
		pixels=new int[size*size];
		this.loadSprite(xCoord,yCoord,sheet);	
	}
	
	private void loadSprite(int xCoord,int yCoord, SpriteSheet sheet) {
		for(int y=0;y<size;y++) {
			for(int x =0;x<size;x++) {
				pixels[x+(y*size)]=sheet.pixels[((xCoord*size)+x)+((yCoord*size)+y)*sheet.width];
			}
		}
	}
	
	public static Sprite getSprite(int tile_code) {
		if(tile_code==0xFF75F94D) {
			return grass;
		}else {
			return water;
		}
	}
	public static Sprite grass= new Sprite(2,0,SpriteSheet.grass);
	public static Sprite water= new Sprite(4,0,SpriteSheet.shore);
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

