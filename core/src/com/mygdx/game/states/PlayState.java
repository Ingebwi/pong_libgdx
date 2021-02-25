package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Pong;
import com.mygdx.game.sprites.Ball;
import com.mygdx.game.sprites.Paddle;

public class PlayState implements State{

    private BitmapFont font = new BitmapFont();

    //Sprites:
    private Ball ball;
    private Texture field;
    private Paddle paddle_l; //paddle on left side
    private Paddle paddle_r; //paddle on rigth side

    //Variables:
    private int pl_score = 0;
    private int pr_score = 0;
    private int max_score = 3;

    private int Paddle_Counter = 0;

    protected PlayState(){
        ball = Ball.getInstance();
        paddle_r = new Paddle(Pong.WIDTH - 20, Pong.HEIGHT / 2);
        paddle_l = new Paddle(0, Pong.HEIGHT / 2);
        field = new Texture("field.png");
        font.setColor(Color.WHITE);
        font.getData().scale(1);

    }


    @Override
    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            paddle_r.update(true);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            paddle_r.update(false);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            paddle_l.update(true);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            paddle_l.update(false);
        }


        if (ball.collides(paddle_l.getRectangle()) || ball.collides(paddle_r.getRectangle())){
            ball.changeDirection();
            //TODO: implement a method to keep track of number of hits
            //Paddle_Counter +=1;

        }


         //TODO: implement a pause-state.
        //Comment: Right now it wont pause properly. the .freeze() will just crash the rendering, and the ball dissappears.

//        if(pause = false && Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
//            pause = true;
//            ball.freeze();
//        }
//        if(pause = true && Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
//            pause = false;
//            ball.unfreeze();
//        }


    }

    @Override
    public void update(float dt) {
        handleInput();

        int point = ball.move(dt);
        if (point != 0){
            if (point > 0){
                pr_score ++;
            }
            else{
                pl_score ++;
            }
        }

        if (pr_score >= max_score || pl_score >= max_score){
            gsm.set(new EndState());
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(field,  0,Pong.HEIGHT / 3, Pong.WIDTH, Pong.HEIGHT / 3);
        sb.draw(ball.getTexture(), ball.getPosition().x, ball.getPosition().y, 20, 20);

        sb.draw(paddle_l.getTexture(), paddle_l.getPosition().x, paddle_l.getPosition().y, 20, 40);
        sb.draw(paddle_r.getTexture(), paddle_r.getPosition().x, paddle_r.getPosition().y, 20, 40);
        font.draw(sb, String.valueOf(pl_score), Pong.WIDTH / 2 -25, Pong.HEIGHT * 2/3 - 18);
        font.draw(sb, String.valueOf(pr_score), Pong.WIDTH / 2 + 25, Pong.HEIGHT * 2/3-18);
        System.out.println("Player 1: " + pl_score + ", Player 2: " + pr_score);
        sb.end();

    }

    @Override
    public void dispose() {

    }


//    public boolean checkPaddleCounter(){
//        return Paddle_Counter >= 5;
//    }



}
