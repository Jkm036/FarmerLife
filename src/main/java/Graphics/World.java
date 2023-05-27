package Graphics;

import java.util.ArrayList;

import Dialogue.Talkable;
import Entities.Entity;
import Entities.Mobs.Mob;
import Entities.Mobs.MobSpawner;
import Entities.Mobs.Player;
import Entities.Mobs.Character;
import Event.Action;
import Event.ActionListener;
import Event.KeyPressed;
import Event.MousePressed;
import Graphics.Tiles.HomeOneTile;
import Graphics.Tiles.Tile;
import Graphics.Tiles.VoidTile;
import Main.Game;

public class World extends GraphicLoadable implements ActionListener{
	//background will be a list of MAP_SIZExMAP_SIZE pixels
 public int background[];
 public static int foreground[];
 public Player player;
 int xScroll,yScroll;
 public boolean up,down,left, right;
 public static int MAP_WIDTH;
 public static int MAP_HEIGHT;
 private ArrayList<Entity>     entities=       new ArrayList<Entity>();
 private ArrayList<Mob>        mobs =          new ArrayList<Mob>();
 private ArrayList <Talkable>  talkable =      new ArrayList<Talkable>();
 private ArrayList <Talkable>  intalkrange=    new ArrayList<Talkable>();
 private ArrayList <Entity>    inattackrange = new ArrayList<Entity>();
 MobSpawner spawner;
 
  public World(String path, Player player){
	  super(path);
	 this.MAP_WIDTH=width;
	 this.MAP_HEIGHT=height;
	 this.player=player;
	 this.xScroll=((player.getX())-(Game.screen.screen_width>>1));
	 this.yScroll=((player.getY())-(Game.screen.screen_height>>1)); 
	 //this.background=pixels;
	 background = copy_array(pixels);
	 this.load("/foreground.png");
	 foreground = copy_array(pixels);
	 this.player=player;
	 entities.add(this.player);
	 spawner=new MobSpawner(this);
	 spawner.spawn(MobSpawner.Type.BJORG);
  }
  private int[] copy_array( int arg2[]) {
	  int arg1[]=new int[arg2.length];
	  for(int i=0;i< arg2.length;i++) {
		  arg1[i]=arg2[i];
	  }
	  return arg1;
  }
  public void render() {
	  Game.screen.render_map(this,xScroll,yScroll);
	  for(Entity e: entities) {
		  e.render();
	  }
	  if(player.inInventory)
		  Game.screen.render_inventory();
  }
  public void tick() {
	for(Entity e: entities) {
		  e.tick();
	}
	
	  xScroll=((player.getX())-(Game.screen.screen_width>>1));
	  yScroll=((player.getY())-(Game.screen.screen_height>>1));
	  //when to start dialogue with character
	for(Talkable t: talkable) {
		if( (Math.sqrt(Math.pow(Math.abs(((Entity)t).getX()-player.getX()), 2)  + 
				       Math.pow(Math.abs(((Entity)t).getY()-player.getY()),2))) < 20 ) 
		{
			intalkrange.add(t);
		}else {
			intalkrange.remove(t);
		}	
	}
	for(Mob m: mobs) {
		if ( (Math.sqrt(Math.pow(Math.abs(((Entity)m).getX()-player.getX()), 2)  + 
			            Math.pow(Math.abs(((Entity)m).getY()-player.getY()),2))) < 10 ) {
			inattackrange.add(m);
		}else {
			inattackrange.remove(m);
		}
	}
	  
  }

public void addEntity(Entity e) {
	entities.add(e);
	if(e instanceof Mob) {
		mobs.add((Mob)e);
	}
	if(e instanceof Talkable) {
		talkable.add((Talkable) e);
	}
}
public static Tile getBackgroundTile(int x, int y) {
	switch(foreground[x +(y * MAP_WIDTH)]) {  
	case 0xFF75F94D: 
		return Tile.grassTile;
	default:
		return Tile.voidTile;
		
}
	
}
public static Tile getTile(int x, int y) {
	if(x >= MAP_WIDTH || x< 0 || y>=MAP_HEIGHT || y<0)
		return Tile.voidTile;
	switch(foreground[x +(y * MAP_WIDTH)]) {  
		case 0xFFFFC90E: 
			return Tile.homeOneTile;
		case 0xFFC1FF00: 
			return Tile.wheatOneTile;
		case 0xFFCDFF02: 
			return Tile.wheatTwoTile;
		case 0xFFE5FF02: 
			return Tile.wheatThreeTile;
		case 0xFFFFEF00: 
			return Tile.wheatFourTile;
		default:
			return getBackgroundTile(x, y);
			
	}
}
public void Listen(Action a) {
	if(!player.inDialogue) {
		if(a instanceof KeyPressed) {
			switch(a.type) {
			case E:
				if(intalkrange.size() >0) {
					player.startDialogue(((Character)intalkrange.get(0)));
								
				}
			return;
			}
		}
		if(a instanceof MousePressed) {
			if(inattackrange.size()>0)
				inattackrange.get(0).gotHit();
		}
	}
	player.Listen(a);
}
}
