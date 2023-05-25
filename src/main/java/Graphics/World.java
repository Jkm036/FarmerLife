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
import Main.Game;

public class World extends GraphicLoadable implements ActionListener{
	//background will be a list of MAP_SIZExMAP_SIZE pixels
 public int background[];
 public int foreground[];
 public Player player;
 int xScroll,yScroll;
 public boolean up,down,left, right;
 public int MAP_WIDTH,MAP_HEIGHT;
 private ArrayList<Entity>     entities= new ArrayList<Entity>();
 private ArrayList<Mob>        mobs = new ArrayList<Mob>();
 private ArrayList <Talkable>  talkable = new ArrayList<Talkable>();
 private ArrayList <Talkable>  intalkrange= new ArrayList<Talkable>();
 MobSpawner spawner;
 
  public World(String path, Player player){
	  super(path);
	 this.MAP_WIDTH=width;
	 this.MAP_HEIGHT=height;
	 this.player=player;
	 this.xScroll=((player.getX())-(Game.screen.screen_width>>1));
	 this.yScroll=((player.getY())-(Game.screen.screen_height>>1)); 
	 this.background=pixels;
	 this.player=player;
	 entities.add(this.player);
	 spawner=new MobSpawner(this);
	 spawner.spawn(MobSpawner.Type.BJORG);
  }
  
  public void render() {
	  Game.screen.render_map(this,xScroll,yScroll);
	  for(Entity e: entities) {
		  e.render();
	  }
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
	}
	player.Listen(a);
}
}
