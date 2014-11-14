package nx.examen;

import java.util.ArrayList;

import javafx.scene.layout.Region;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Game extends ApplicationAdapter {
	/*
	 * Maximos
	 * X = 580
	 * Y = 425
	 */
	
	//Stages
	Stage menu;
	Stage game;
	Stage fondo;
	
	//Actores
	Bomba bomb;
	SplashScreen inicio;
	Zombie zombie;
	Esque esque;
	ArrayList<Actor> actores;
	
	//HerramientasActores
	Texture text;
	Image image, image2;
	
	
	//Estadisticas
	private static int bombasD = 0;
	private static int destruidos = 0;
	private static int pasados = 0;
	private static boolean GameOver = false;
	
	
	//Contadores
	int cont = 0;
	
	//Extra
	Image nave;
	int x = 0;
	int y = 0;
	Music music;
	
	@Override
	public void create () {
		cont = 0;
		menu = new Stage();
		game = new Stage();
		fondo = new Stage();
		
		Gdx.input.setInputProcessor(menu);
		text = new Texture("splash.png");
		inicio = new SplashScreen(text);
		menu.addActor(inicio);
		
		text = new Texture("nave.png");
		nave = new Image(text);
		nave.setX(x);
		nave.setY(y);
		nave.setWidth(50);
		nave.setHeight(50);
		menu.addActor(nave);
		
		music = Gdx.audio.newMusic(Gdx.files.getFileHandle("sound.mp3", FileType.Internal));
		music.setLooping(true);
		music.play();
	}
	
	public static void plusDestruidos(){
		
		destruidos++;
	}
	
	public static void plusPasados(){
		pasados++;
	}
	
	public static void plusBombasD(){
		bombasD++;
	}
	
	public void setGameOver(){
		if (destruidos >= 100 || pasados >= 5){
			GameOver = true;
		}
	}
	
	public static void setGameOver(boolean go){
		GameOver = go;
	}
	
	public void printFondo(){
		text = new Texture("pasto2.jpg");
		image = new Image(text);
		
		text = new Texture("pasto1.png");
		image2 = new Image(text);
		
		image.setWidth(60);
		image.setHeight(40);
		image2.setWidth(100);
		image2.setHeight(40);
		
		fondo.addActor(image);
		fondo.addActor(image2);
		for (int x = 0; x < 660; x+=60){
			image.setX(x);
			image.setY(0);
			image2.setX(x);
			image2.setY(40);
			
			fondo.act();
			fondo.draw();
		}
		
	}
	
	public void crearBombas(){
		bomb = new Bomba(new Texture("bomba.png"));
		game.addActor(bomb);
	}
	
	public void crearZombies(){
		zombie = new Zombie(new Texture("zombie.png"));
		game.addActor(zombie);
	}
	
	public void crearEsque(){
		esque = new Esque(new Texture("esque.png"));
		game.addActor(esque);
	}
	
	public void crearActores(){
		crearBombas();
		crearZombies();
		crearEsque();
	}
	
	public void moverTeclado(){
		if (Gdx.input.isKeyPressed(Input.Keys.UP)){
			y++;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			y--;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			x--;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			x++;
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if (cont == 0){
			moverTeclado();
			nave.setX(x);
			nave.setY(y);
			
			//menu.draw();
			menu.act();
			menu.draw();
			
		}
		
		if (inicio.finish()){
			cont++;
			Gdx.input.setInputProcessor(game);
			//printFondo();
			
				game.act();
				game.draw();
				if (cont%100 == 0)
					crearZombies();
				if (cont%150 == 0)
					crearEsque();
				if (cont%200 == 0)
					crearBombas();
			
				
		}
		
		setGameOver();
		if (GameOver == true){
			destruidos = 0;
			pasados = 0;
			create();
			GameOver = false;
			music.stop();
		}
			
	}
}
