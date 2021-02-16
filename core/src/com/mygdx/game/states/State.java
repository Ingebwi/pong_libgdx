package com.mygdx.game.states;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public interface State {

    //Java-pattern

    GameStateManager gsm = new GameStateManager();


    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();


}
