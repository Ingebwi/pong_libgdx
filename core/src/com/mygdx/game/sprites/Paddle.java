package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Pong;

public class Paddle {

    private Texture texture;
    private Vector3 position;
    private Rectangle rectangle;

    public static int PADDLE_SPEED = 4;

    int height;
    int width;
    int maxY; //Paddle can't get higher than this
    int minY; //Paddle can't get lower than this

    public Paddle(int x, int y){
        texture = new Texture("paddle.png");
        position = new Vector3(x,y,0);
        height = 40;
        width = 20;
        minY = Pong.HEIGHT / 3 + 3;
        maxY = Pong.HEIGHT * 2/3 - 5 - height;
        rectangle = new Rectangle(x , y, width, height);

    }


    public void update(boolean up){
        // for every touch paddle will move 1 coordinate up / down
        if (up){
            if (position.y < maxY)
                position.add(0, PADDLE_SPEED, 0);
        }
        else {
            if (position.y > minY){
                position.add(0, -PADDLE_SPEED, 0);
            }
        }
        rectangle.setPosition(getPosition().x, getPosition().y);
    }

    public Texture getTexture() {

        return texture;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }



}
