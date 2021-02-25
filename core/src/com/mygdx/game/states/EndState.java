package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Pong;

public class EndState implements State{
    Texture field;
    BitmapFont font = new BitmapFont();



    protected EndState() {
        field = new Texture("field.png");

    }

    @Override
    public void handleInput() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            gsm.set(new MenuState());
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
        font.draw(sb, "game over! Press space to get to menu-page", Pong.WIDTH /4 , Pong.HEIGHT /2);
        sb.end();
    }

    @Override
    public void dispose() {

    }


}
