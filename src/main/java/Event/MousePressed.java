package Event;

public class MousePressed extends Action{
private int x;
private int y;

	public MousePressed(int x, int y) {
		super(Action.Type.MOUSEPRESSED);
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
