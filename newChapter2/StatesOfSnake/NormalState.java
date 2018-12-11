package mygames.game.desktop.newChapter2.StatesOfSnake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import mygames.game.desktop.newChapter2.Direction;
import mygames.game.desktop.newChapter2.Snake;

public class NormalState extends MainState {
    private Snake snake;
    public NormalState(Snake newSnake){
        snake = newSnake;
    }
    @Override
    public void act() {
        boolean leftPressed = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean rightPressed = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        boolean upPressed = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean downPressed = Gdx.input.isKeyPressed(Input.Keys.DOWN);

        if (leftPressed && !(snake.getDirection() == Direction.RIGHT)){
            snake.setDirection(Direction.LEFT);
        }else if (rightPressed && !(snake.getDirection() == Direction.LEFT)){
            snake.setDirection(Direction.RIGHT);
        }else if (upPressed && !(snake.getDirection() == Direction.DOWN)){
            snake.setDirection(Direction.UP);
        }else if (downPressed && !(snake.getDirection() == Direction.UP)){
            snake.setDirection(Direction.DOWN);
        }
    }
}
