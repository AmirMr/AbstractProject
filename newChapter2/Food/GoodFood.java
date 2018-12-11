package mygames.game.desktop.newChapter2.Food;

import com.badlogic.gdx.scenes.scene2d.Stage;


public class GoodFood extends BaseFood {
    private float timer;
    public GoodFood(float x, float y, Stage mainStage) {
        super(x, y, mainStage);
    }
    public void act(float dt){
        timer += dt;
        if (timer >= 8f){
            this.remove();
        }
    }
}
