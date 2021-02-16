package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Pong;


public class Ball {

    //Singleton-pattern; only possible to create *one* instance of ball.
    private static final Ball INSTANCE = new Ball(Pong.WIDTH/2, Pong.HEIGHT/2);


    //Some static values.
    public static float minY =Pong.HEIGHT / 3 + 3;
    public static float maxY = Pong.HEIGHT * 2/3 - 3;; //min postition in y-direction
    public static float minX = 0;
    public static float maxX = Pong.WIDTH;


    private Texture texture;
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle rectangle;
    int height = 20;
    int width = 20;

    private Ball(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(150 ,100, 0);
        texture = new Texture("ball.png");
        rectangle = new Rectangle(x, y, height, width);
    }


    //TODO: Make ball go in direction of player that did not score
    //TODO: Make ball go faster after some time --> 6 hits and it speeds up.
    //QUESTION: Should this method be void? Perhaps not...
    public int move(float dt){
        int score = 0;
        if (position.y < minY || position.y + height > maxY) {
            velocity.y = - velocity.y;
        }
        else if (position.x < minX || position.x + height > maxX){
            if (position.x < minX){
                score = 1 ;//left player gets one point
            }
            else{
                score = -1; //right player gets one point
            }
            velocity.x = - velocity.x;
            position = new Vector3(Pong.WIDTH /2 - 10, Pong.HEIGHT / 2, 0);


        }
        velocity.scl(dt);
        position.add(velocity.x, velocity.y, 0);
        rectangle.setPosition(getPosition().x, getPosition().y);
        velocity.scl(1/dt);

        return score;

    }




    public Texture getTexture() {

        return texture;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Vector3 getVelocity() {
        return velocity;
    }

    public boolean collides(Rectangle paddle){
        return rectangle.overlaps(paddle);
    }

    public void changeDirection(){
        velocity.x = - velocity.x;
    }

    public static Ball getInstance(){
        return INSTANCE;
    }


    //TODO: find mistake in pausing-methods
//    public void freeze(){
//        //velocity.scl(dt);
//        position.set(getPosition().x, getPosition().y, 0);
//        rectangle.setPosition(getPosition().x, getPosition().y);
//        //velocity.scl(1/dt);

//    }


//    public void unfreeze(){
        //velocity.scl(dt);
//        position.add(velocity.x, velocity.y, 0);
//        rectangle.setPosition(getPosition().x, getPosition().y);
        //velocity.scl(1/dt);
//    }



    public void startPosition(){
        position = new Vector3(Pong.WIDTH /2 - 10, Pong.HEIGHT / 2, 0);

    }


}
