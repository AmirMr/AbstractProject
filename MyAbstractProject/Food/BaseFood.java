package mygames.game.desktop.MyAbstractProject.Food;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import mygames.game.desktop.MyAbstractProject.ActorBeta;

public class BaseFood extends ActorBeta {
    public BaseFood(float x, float y, Stage mainStage) {
        super(x, y, mainStage);
        setTexture(new Texture(Gdx.files.internal("strawberry.png")));
        setSize(20f,20f);
        updateBounds();
    }
}
