package Inventory;

import Graphics.Sprite;

public class Inventory {
public Sprite sprite;
public InventoryPair items[];
boolean full=false;
int max_items= 18;
	public Inventory() {
		this.sprite=Sprite.inventory;
	}
public static Inventory inventory = new Inventory();
}
