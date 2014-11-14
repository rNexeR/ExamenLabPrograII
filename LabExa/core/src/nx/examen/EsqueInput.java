package nx.examen;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class EsqueInput extends InputListener{
	Esque esque;
	public EsqueInput(Esque e) {
		super();
		esque = e;
	}
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		esque.remove();
		Game.plusDestruidos();
		return super.touchDown(event, x, y, pointer, button);
	}
}
