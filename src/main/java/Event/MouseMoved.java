package Event;

public class MouseMoved extends Action{
private int x;
private int y;
boolean pressed;
	public MouseMoved(int x, int y, boolean pressed) {
		super(Action.Type.MOUSEMOVED);
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		this.pressed=pressed;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
