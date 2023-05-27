package Event;

public class Action {
int keycode;
public static enum Type{
	UP,
	DOWN,
	LEFT,
	RIGHT,
	E,
	ENTER,
	DEL,
	Q,
	R,
	T,
	Y,
	U,
	I,
	O,
	P,
	F,
	G,
	H,
	J,
	K,
	L,
	Z,
	X,
	C,
	V,
	B,
	N,
	M,
	SPACE,
	MOUSEMOVED,
	MOUSEPRESSED,
	BLANK;
	
}
public Type type;

	Action(Type type){
		this.type=type;
	}

}
