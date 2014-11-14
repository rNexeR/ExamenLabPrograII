package nx.examen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SplashScreen extends Image{
	Texture img;
	SplashScreenInput listen;
	SplashScreen (Texture text){
		super(text);
		listen = new SplashScreenInput(this);
		addListener(listen);
		img = text;
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		this.setWidth(640);
		this.setHeight(520);
	}
	
	public boolean finish(){
		return listen.getClic();
	}
}
