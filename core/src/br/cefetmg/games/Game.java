package br.cefetmg.games;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture[] mapLevelsTextures;
    private Goomba goomba;
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        mapLevelsTextures = new Texture[2];
        mapLevelsTextures[0] = new Texture("map-level-1.png");
        mapLevelsTextures[1] = new Texture("map-level-2.png");
        goomba = new Goomba();
        goomba.create();
        
        Gdx.gl.glClearColor(1, 1, 1, 1);        
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        update(Gdx.graphics.getDeltaTime());

        batch.begin();        
            batch.draw(mapLevelsTextures[0], 0, 0);
            goomba.render(batch);
            batch.draw(mapLevelsTextures[1], 0, 0);

        batch.end();
    }

    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
            Gdx.app.exit();
        }
        goomba.update(delta);
    }
    
}
