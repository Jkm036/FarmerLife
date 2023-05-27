package Event;
import java.awt.event.KeyEvent;
public class InputAction extends Action {
int keycode;
	InputAction(int keycode){
		super(calctype(keycode));
		this.keycode=keycode;
	}
	public static Type calctype(int key) {
		switch (key) {
		case KeyEvent.VK_Q:
			return Action.Type.Q;
		case KeyEvent.VK_W:
			return Action.Type.UP;
		case KeyEvent.VK_A:
			return Action.Type.LEFT;
		case KeyEvent.VK_S:
			return Action.Type.DOWN;
		case KeyEvent.VK_D:
			return Action.Type.RIGHT;
		case KeyEvent.VK_E:
			return Action.Type.E;
		case KeyEvent.VK_ENTER:
			return Action.Type.ENTER;
		case KeyEvent.VK_R:
			return Action.Type.R;
		case KeyEvent.VK_T:
			return Action.Type.T;
		case KeyEvent.VK_Y:
			return Action.Type.Y;
		case KeyEvent.VK_U:
			return Action.Type.U;
		case KeyEvent.VK_I:
			return Action.Type.I;
		case KeyEvent.VK_O:
			return Action.Type.O;
		case KeyEvent.VK_P:
			return Action.Type.P;
		case KeyEvent.VK_F:
			return Action.Type.F;
		case KeyEvent.VK_G:
			return Action.Type.G;
		case KeyEvent.VK_H:
			return Action.Type.H;
		case KeyEvent.VK_J:
			return Action.Type.J;
		case KeyEvent.VK_K:
			return Action.Type.K;
		case KeyEvent.VK_L:
			return Action.Type.L;
		case KeyEvent.VK_Z:
			return Action.Type.Z;
		case KeyEvent.VK_X:
			return Action.Type.X;
		case KeyEvent.VK_C:
			return Action.Type.C;
		case KeyEvent.VK_V:
			return Action.Type.V;
		case KeyEvent.VK_B:
			return Action.Type.B;
		case KeyEvent.VK_N:
			return Action.Type.N;
		case KeyEvent.VK_M:
			return Action.Type.M;		
		case KeyEvent.VK_BACK_SPACE:
			return Action.Type.DEL;
		case KeyEvent.VK_SPACE:
			return Action.Type.SPACE;
		default:
			return Action.Type.BLANK;
			
		}
	}
}
