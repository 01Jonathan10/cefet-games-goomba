package br.cefetmg.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
//import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Goomba {

    private Texture texture;
//    private Sprite sprite;
    float x;
    float y;
    private TextureRegion[][] frames;
    private Animation<TextureRegion>[] walking;
    private float animationTimer;
    private int direction;
    private boolean isWalking;
    
    public void create() {
        texture = new Texture("goomba-spritesheet.png");
//        sprite = new Sprite(texture);
        x=30;
        y=10;
        walking = new Animation[4];
        
        frames = TextureRegion.split(texture, 21, 24);
        for (int i=0;i<=3;i++){
            walking[i] = new Animation(0.1f,
                frames[i][0], 
                frames[i][1], 
                frames[i][2],
                frames[i][3],
                frames[i][4]);
            walking[i].setPlayMode(PlayMode.LOOP_PINGPONG);
        }
        direction = 0;
        animationTimer = 0;
//        sprite.setPosition(x, y);  
    }

    public void render(SpriteBatch batch) {
//        sprite.draw(batch);
        batch.draw(walking[direction].getKeyFrame(animationTimer), x, y);
    }

    public void update(float delta) {
        isWalking = false;
        
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            y = Math.max(0, y-delta*100);
//            sprite.setPosition(x, y);
            isWalking = true;
            direction = 0;
        }
        
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
//            x = Math.min(Gdx.graphics.getWidth() - sprite.getWidth(), x+delta*100);
            x = Math.min(Gdx.graphics.getWidth() - 21, x+delta*100);
//            sprite.setPosition(x, y);
            isWalking = true;
            direction = 1;
        }
                
        if (Gdx.input.isKeyPressed(Keys.UP)) {
//            y = Math.min(Gdx.graphics.getHeight() - sprite.getHeight(), y+delta*100);
            y = Math.min(Gdx.graphics.getHeight() - 24, y+delta*100);
//            sprite.setPosition(x, y);
            isWalking = true;
            direction = 2;
        }

        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            x = Math.max(0, x-delta*100);
//            sprite.setPosition(x, y);
            isWalking = true;
            direction = 3;
        }
        
        animationTimer += Gdx.graphics.getDeltaTime();
        if (!isWalking){animationTimer = 0.2f;}
    }
    
}
