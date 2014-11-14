package nx.examen;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class ZombieInput extends InputListener{
	Zombie zmb;
	int clics = 3;
	public ZombieInput(Zombie z) {
		super();
		zmb = z;
	}
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		clics--;
		if (clics <= 0)
			zmb.remove();
		return super.touchDown(event, x, y, pointer, button);
	}
}
