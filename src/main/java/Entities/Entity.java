package Entities;


public abstract class Entity {
protected int xPos;
protected int yPos;
	
	
	public abstract void tick();
	public abstract void render();
	public abstract void gotHit();
	public int getX() {
		return xPos;
	}
	public int getY() {
		return yPos;
	}

	public void setX(int x) {
		this.xPos = x;
	}
	public void setY(int y) {
		this.yPos = y;
	}

}
