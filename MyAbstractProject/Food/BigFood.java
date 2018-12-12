package mygames.game.desktop.MyAbstractProject.Food;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import mygames.game.desktop.MyAbstractProject.GameBeta;


public class BigFood extends BaseFood {
    private int count=10;
    private float timer=0f;
    private Label label;
    public BigFood(float x, float y, Stage mainStage) {
        super(x, y, mainStage);
        setTexture(new Texture(Gdx.files.internal("bananas.png")));
        label=new Label("Score:", GameBeta.labelStyle);
        label.setColor(Color.CYAN);
        label.setPosition(this.getX()-10,this.getY()+10);
        mainStage.addActor(label);
    }
    public void act(float dt){
        timer+=dt;
        if (timer<1){
            setScale(1);
        }else if (timer >= 1 && timer < 2){
            setScale(1.1f);
            count=10;
        }else if (timer >= 2 && timer < 3){
            setScale(1);
            count=8;
        }else if (timer >= 3 && timer < 4) {
            setScale(1.1f);
            count=6;
        }else if (timer >= 4 && timer < 5){
            setScale(1);
            count=4;
        }else {
            setScale(1.1f);
            count=2;
        }
        if (timer>6f){
            this.remove();
            label.remove();
        }
        label.setText(""+count);
    }
    public int getCount() {
        return count;
    }
    public Label getLabel() {
        return label;
    }
}
