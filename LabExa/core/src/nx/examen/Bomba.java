package nx.examen;


import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Bomba extends Image{
	int x = 2;
	Random rnd = new Random();
	
	public Bomba(Texture text){
		super(text);
		int x = rnd.nextInt(580)+1;
		if (x<290)
			this.x = 3;
		else
			this.x = -3;
		this.setX(x);
		this.setY(425);
		addListener(new BombaInput(this));
		
	}

	public void act(float delta){
		super.act(delta);
		this.setWidth(60);
		this.setHeight(50);
		if (this.getX()<=1){
			x = 3;
		}else if (this.getX()>=580){
			x = -3;
		}
		this.setX(this.getX()+x);
		this.setY(this.getY()-1);
	}
	
}
