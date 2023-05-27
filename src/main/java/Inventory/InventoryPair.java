package Inventory;

import Graphics.Sprite;

public class InventoryPair {
Item item;
int num;
Sprite sprite;
 public InventoryPair(Item item) {
	 this.item=item;
	 this.sprite=item.sprite;
 }
}
