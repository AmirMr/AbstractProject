package mygames.game.desktop.MyAbstractProject;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
public class ActorBeta extends Actor {
    private TextureRegion textureRegion;
    private Rectangle rectangle;
    private Stage mainStage;
    public ActorBeta(float x, float y, Stage newMainStage) {
        super();
        setPosition(x,y);
        mainStage = newMainStage;
        textureRegion = new TextureRegion();
        rectangle = new Rectangle();
    }

    public void addActorToStage() {
        mainStage.addActor(this);
    }
    public void setTexture(Texture t) {
        this.textureRegion.setRegion(t);
        this.setSize((float)t.getWidth(), (float)t.getHeight());
        this.rectangle.setSize((float)t.getWidth(), (float)t.getHeight());
    }
    public TextureRegion getTextureRegion() {
        return textureRegion;
    }
    public Rectangle getRectangle() {
        this.rectangle.setPosition(this.getX(), this.getY());
        return this.rectangle;
    }
    public void updateBounds(){
        this.rectangle.setPosition(this.getX(), this.getY());
        this.rectangle.setSize(getWidth(),getHeight());
    }
    public boolean overlaps(ActorBeta other) {
        return this.getRectangle().overlaps(other.getRectangle());
    }

    public void act(float dt) {
        super.act(dt);
    }
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        Color c = this.getColor();
        batch.setColor(c.r, c.g, c.b, c.a);
        if (this.isVisible()) {
            batch.draw(this.textureRegion, this.getX(), this.getY(), this.getOriginX(), this.getOriginY(),
                    this.getWidth(), this.getHeight(), this.getScaleX(), this.getScaleY(), this.getRotation());
        }
    }
}