package Graphics.Tiles;

import Entities.Entity;
import Graphics.Sprite;

public class Tile extends Entity{
public static int grass_col=               0xFF75F94D;
public static int home_one_col=            0xFFFFC90E;
public static int transparent_col=         0xFFFF00FA;
public static int dark_dead_grass_col=     0xFF9C7B2D;
public static int dark_dead_grass_one_col= 0xFF94752B;
public static int wheat_one_col=           0xFFC1FF00;
public static int wheat_two_col=           0xFFCDFF02;
public static int wheat_three_col=         0xFFE5FF02;
public static int wheat_four_col=          0xFFFFEF00;


Sprite sprite;
public boolean solid;
int col;
	public Tile(Sprite sprite) {
		this.sprite=sprite;
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public static Tile grassTile=                new GrassTile(Sprite.grass);
	public static Tile darkDeadGrassTile=        new GrassTile(Sprite.dead_grass_dark);
	public static Tile darkDeadGrassTileOne=     new GrassTile(Sprite.dead_grass_dark_one);
	public static Tile homeOneTile=              new HomeOneTile(Sprite.home_one);
	public static Tile voidTile=                 new VoidTile(Sprite.water);
	public static Tile wheatOneTile=                 new WheatTile(Sprite.wheat_one,  (byte)1);
	public static Tile wheatTwoTile=                 new WheatTile(Sprite.wheat_two,  (byte)2);
	public static Tile wheatThreeTile=               new WheatTile(Sprite.wheat_three,(byte)3);
	public static Tile wheatFourTile=                new WheatTile(Sprite.wheat_four, (byte)4);
	@Override
	public void gotHit() {
		// TODO Auto-generated method stub
		
	}
}
