package com.hellworld.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;



public class helloWorldLibGDX extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("world.jpg");
	}

	@Override
	public void render () {
		//Gdx.gl.glClearColor(1, 1, 1, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ScreenUtils.clear(0,0,0,0);
		batch.begin();
		batch.draw( img, 0, 0 );
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}