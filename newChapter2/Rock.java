package mygames.game.desktop.newChapter2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Rock extends ActorBeta {
    public Rock(float x, float y, Stage mainStage) {
        super(x, y, mainStage);
        setTexture(new Texture(Gdx.files.internal("assets3/rock.png")));
        setSize(28f,28f);
        updateBounds();
        this.addActorToStage();
    }
}
