package nx.examen;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class SplashScreenInput extends InputListener{
	SplashScreen ini;
	boolean clic = false;
	public SplashScreenInput(SplashScreen i) {
		super();
		ini = i;
	}
	
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		// TODO Auto-generated method stub
		//System.out.println("Touch Down");
		//Desaparecer Enemigo
		ini.remove();
		clic = true;
		return super.touchDown(event, x, y, pointer, button);
	}
	
	public boolean getClic(){
		return clic;
	}
}
