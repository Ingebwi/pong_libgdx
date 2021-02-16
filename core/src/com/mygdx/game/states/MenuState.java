package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Pong;

import java.awt.Button;

public class MenuState implements State{
    Texture field;
    Texture playBtn;

    BitmapFont font = new BitmapFont();



    public MenuState() {
        field = new Texture("field.png");
        playBtn = new Texture("playbtn.png");

    }

    @Override
    public void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            gsm.set(new PlayState());
        }


    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(field,  0, Pong.HEIGHT / 3, Pong.WIDTH, Pong.HEIGHT / 3);
        sb.draw(playBtn, Pong.WIDTH/2 - playBtn.getWidth()/2, Pong.HEIGHT/2 - playBtn.getHeight()/2);
        font.draw(sb, "press Enter to begin pong", Pong.WIDTH/3 , Pong.HEIGHT/2 - playBtn.getHeight() - 15);
        font.draw(sb, "player left; use keys W/S", Pong.WIDTH/3, Pong.HEIGHT/2 - playBtn.getHeight() - 35);
        font.draw(sb, "player right; use keys up/down", Pong.WIDTH/3, Pong.HEIGHT/2 - playBtn.getHeight() - 55);

        sb.end();
    }

    @Override
    public void dispose() {

    }


}
