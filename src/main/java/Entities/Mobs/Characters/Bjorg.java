package Entities.Mobs.Characters;
import Entities.Mobs.Character;
import Graphics.Sprite;
public class Bjorg extends Character {

	public Bjorg(int xPos, int yPos) {
		super(xPos, yPos, "Nice Warrior");
		// TODO Auto-generated constructor stub
		size=16;
		sprite=Sprite.bjorg_f;
		static_sprite=Sprite.bjorg_f;
		up1=Sprite.bjorg_up1;
		up2=Sprite.bjorg_up2;
		right1=Sprite.bjorg_right1;
		right2=Sprite.bjorg_right2;
		left1=Sprite.bjorg_left1;
		left2=Sprite.bjorg_left2;
		down1=Sprite.bjorg_down1;
		down2=Sprite.bjorg_down2;		
	}

}
