package Entities.Mobs;

import Graphics.Sprite;

public class Mammoth extends Mob{

	Mammoth(int xPos, int yPos) {
		super(xPos, yPos);
		size=16;
		sprite=Sprite.mammoth_f;
		static_sprite=Sprite.mammoth_f;
		up1=Sprite.mammoth_up1;
		up2=Sprite.mammoth_up2;
		down1=Sprite.mammoth_down1;
		down2=Sprite.mammoth_down2;
		right1=Sprite.mammoth_right1;
		right2=Sprite.mammoth_right2;
		left1=Sprite.mammoth_left1;
		left2=Sprite.mammoth_left2;

	}


}
