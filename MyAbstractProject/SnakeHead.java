package mygames.game.desktop.MyAbstractProject;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class SnakeHead extends ActorBeta {

    public SnakeHead(float x, float y, Stage mainStage) {
        super(x, y, mainStage);
    }
    public void updateX(float amount){
        setX(getX()+amount);
        updateBounds();
    }
    public void updateY(float amount){
        setY(getY() + amount);
        updateBounds();
    }
}