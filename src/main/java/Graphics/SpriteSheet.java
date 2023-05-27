package Graphics;



public class SpriteSheet extends GraphicLoadable {
	
	SpriteSheet(String path){
		super(path);
	}
	
	public static SpriteSheet grass= new SpriteSheet("/MiniWorldSprites/Ground/Grass.png");
	public static SpriteSheet houses= new SpriteSheet("/MiniWorldSprites/Buildings/Wood/Houses.png");
	public static SpriteSheet shore= new SpriteSheet("/MiniWorldSprites/Ground/Shore.png");
	public static SpriteSheet player= new SpriteSheet("/MiniWorldSprites/Characters/Workers/FarmerTemplate.png");
	public static SpriteSheet mammoth= new SpriteSheet("/MiniWorldSprites/Characters/Monsters/Frostborn/Mammoth.png");
	public static SpriteSheet bjorg= new SpriteSheet("/MiniWorldSprites/Characters/Champions/Bjorg.png");
	public static SpriteSheet deadGrass= new SpriteSheet("/MiniWorldSprites/Ground/DeadGrass.png");
	public static SpriteSheet texturedGrass= new SpriteSheet("/MiniWorldSprites/Ground/TexturedGrass.png");
	public static SpriteSheet wheatField= new SpriteSheet("/MiniWorldSprites/Nature/Wheatfield.png");
	public static SpriteSheet allAssets= new SpriteSheet("/MiniWorldSprites/AllAssetsPreview.png");
	
	public static SpriteSheet inventory= new SpriteSheet("/Inventory.png");
}
