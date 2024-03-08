/*
The original code was as follows, but I had to make changes in order to work with the
newer version of LibGDX.

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

public class HelloWorldImage extends Game {

	public void create() {

		FileHandle worldFile = Gdx.files.internal("world.png")
		texture = new Texture(worldFile);
		batch = new SpriteBatch();
	}

	public void render() {

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw( texture, 192, 112);
		batch.end()
	}
}

The app also called for an additional class to be created called helloLauncher as well.

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
public class HelloLauncher {

	public static void main(String[] args) {

		HelloWorldImage myProgram = new HelloWorldImage();
		LwjglAppication launcher = new LwjglApplication( myProgram );
	}
}


When it came to running this code on the most recent version of LibGDX, and I assume
of Lwjgl, using the separate HelloLauncher did not work. It turns out it was not
necessary to use two classes to run this project. In the automatically generated
code from MyGdxGame.java, the following imports were not used:

com.badlogic.gdx.Game
com.badlogic.gdx.Gdx
com.badlogic.gdx.files.FileHandle
com.badlogic.gdx.graphics.GL20

 */

package com.hellworld.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

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
