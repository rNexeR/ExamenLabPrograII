package nx.examen;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Zombie extends Image{
	Random rnd = new Random();
	public Zombie(Texture text) {
		super(text);
		int x = rnd.nextInt(580)+1;
		this.setX(x);
		this.setY(425);
		addListener(new ZombieInput(this));
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		this.setWidth(60);
		this.setHeight(50);
		this.setY(getY()-2);
		
		if (this.getY()<=0){
			this.remove();
			Game.plusPasados();
		}
	}
}
