package mygames.game.desktop.MyAbstractProject.Food;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BeerFood extends BaseFood {
    private float timer;
    public BeerFood(float x, float y, Stage mainStage) {
        super(x, y, mainStage);
        setTexture(new Texture(Gdx.files.internal("beer-mug.png")));
    }
    public void act(float dt){
        timer += dt;
        if (timer >= 6f){
            this.remove();
        }
    }
}
