package mygames.game.desktop.newChapter2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import mygames.game.desktop.newChapter2.StatesOfSnake.HardState;
import mygames.game.desktop.newChapter2.StatesOfSnake.MainState;
import mygames.game.desktop.newChapter2.StatesOfSnake.NormalState;

public class Snake{
    private SnakeHead head;
    private Direction direction = Direction.RIGHT;
    private final Array<BodyPart> bodyParts = new Array<BodyPart>();
    private Stage mainStage;
    private float xBeforeUpdate;
    private float yBeforeUpdate;
    private MainState currentState;

    private HardState hardState;
    private NormalState normalState;
    public Snake(float x,float y,Stage mainStage){
        this.mainStage = mainStage;
        head = new SnakeHead(x,y, mainStage);

        hardState = new HardState(this);
        normalState = new NormalState(this);
        currentState = normalState;
    }
    public void move(){
        currentState.act();
        if (head.getX() > GameConfig.width){
            head.setPosition(0f, head.getY());
        }else if (head.getX() < 0){
            head.setPosition(GameConfig.width, head.getY());
        }
        if (head.getY() > GameConfig.height){
            head.setPosition(head.getX(), 0f);
        }else if (head.getY() < 0){
            head.setPosition(head.getX(), GameConfig.height);
        }
        xBeforeUpdate = head.getX();
        yBeforeUpdate = head.getY();

        if (direction.isRight()){
            head.updateX(GameConfig.Snake_SPEED);
        }else if (direction.isLeft()){
            head.updateX(-GameConfig.Snake_SPEED);
        }else if (direction.isUp()){
            head.updateY(GameConfig.Snake_SPEED);
        }else if (direction.isDown() ){
            head.updateY(-GameConfig.Snake_SPEED);
        }

        updateBodyParts();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public SnakeHead getHead() {
        return head;
    }
    public Array<BodyPart> getBodyParts() {
        return bodyParts;
    }
    public void insertBodyPart(){
        BodyPart bodyPart = new BodyPart(head.getX(), head.getY(), this.mainStage);
        bodyPart.setTexture(new Texture(Gdx.files.internal("assetsPr/snake.png")));
        bodyParts.insert(0, bodyPart);
    }
    private void updateBodyParts(){
        if (bodyParts.size > 0){
            BodyPart tail = bodyParts.removeIndex(0);
            tail.setPosition(xBeforeUpdate, yBeforeUpdate);
            bodyParts.add(tail);
        }
    }
    public Direction getDirection() {
        return direction;
    }

    public void setCurrentState(MainState currentState) {
        this.currentState = currentState;
    }

    public HardState getHardState() {
        return hardState;
    }
}











