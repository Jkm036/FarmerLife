package Entities.Mobs;

import java.util.ArrayList;

import Entities.Entity;
import Entities.Mobs.Characters.Bjorg;
import Graphics.World;
import Main.Game;

public class MobSpawner {
World world;
public static enum Type{
	MAMMOTH,BJORG
}
 public MobSpawner(World world){
	this.world=world;
 }
 public void spawn(MobSpawner.Type m) {
	 switch(m) {
	 case MAMMOTH:
		 world.addEntity(new Mammoth(2*Game.SIZE,3*Game.SIZE));
		 break;
	 case BJORG:
		 world.addEntity(new Bjorg(2*Game.SIZE,3*Game.SIZE));
	default:
		break;
	 }
 }
}
