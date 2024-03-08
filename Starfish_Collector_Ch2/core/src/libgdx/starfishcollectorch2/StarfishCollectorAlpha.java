package libgdx.starfishcollectorch2;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Game;
public class StarfishCollectorAlpha extends Game {

    private SpriteBatch batch;

    private Texture turtleTexture;
    private float turtleX;
    private float turtleY;
    private Rectangle turtleRectangle;

    private Texture starfishTexture;
    private float starfishX;
    private float starfishY;
    private Rectangle starfishRectangle;

    private Texture oceanTexture;
    private Texture winMessageTexture;

    private boolean win;

    public void create() {

        // This method appears to be creating all the images that will be viewable in game window.
        batch = new SpriteBatch();

        turtleTexture = new Texture( Gdx.files.internal("turtleGimp3.png"));
        turtleX = 20;
        turtleY = 20;
        turtleRectangle = new Rectangle( turtleX, turtleY, turtleTexture.getWidth(), turtleTexture.getHeight() );

        starfishTexture = new Texture( Gdx.files.internal("starfish.png"));
        starfishX = 380;
        starfishY = 380;
        starfishRectangle = new Rectangle( starfishX, starfishY, starfishTexture.getWidth(), starfishTexture.getHeight());

        oceanTexture = new Texture( Gdx.files.internal("water.png"));

        winMessageTexture = new Texture( Gdx.files.internal("victory.png") );

        win = false;
    }

    public void render() {

        // Checking user input
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {

            turtleX = turtleX - 3;
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {

            turtleX = turtleX + 3;
        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {

            turtleY = turtleY + 3;
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {

            turtleY = turtleY - 3;
        }

        // Update turtle rectangle position
        turtleRectangle.setPosition(turtleX, turtleY);

        // Check win condition: turtle must be overlapping starfish
        if (turtleRectangle.overlaps(starfishRectangle)) {

            win = true;
        }

        // clear screen
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // draw graphics
        batch.begin();
        batch.draw( oceanTexture, 0, 0);
        if (!win) {
            batch.draw( starfishTexture, starfishX, starfishY );
            batch.draw( turtleTexture, turtleX, turtleY );
        }

        if (win) {
            batch.draw( winMessageTexture, 400, 220);
        }

        batch.end();
    }
}
