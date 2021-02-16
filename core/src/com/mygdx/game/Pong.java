package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.sprites.Ball;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MenuState;
import com.mygdx.game.states.State;

public class Pong extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "pong";
	public static GameStateManager gsm = State.gsm;


	private SpriteBatch batch;





	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm.push(new MenuState());
		Gdx.gl.glClearColor(0, 0, 0 , 1);


	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);


	}
}
