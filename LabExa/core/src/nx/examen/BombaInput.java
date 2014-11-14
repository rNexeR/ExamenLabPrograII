package nx.examen;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class BombaInput extends InputListener{
	Bomba bmb;
	
	public BombaInput(Bomba boom){
		super();
		bmb = boom;
	}
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		// TODO Auto-generated method stub
		bmb.remove();
		Game.setGameOver(true);
		return super.touchDown(event, x, y, pointer, button);
	}

}
