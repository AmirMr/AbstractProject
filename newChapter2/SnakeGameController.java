package mygames.game.desktop.newChapter2;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.Array;
import mygames.game.desktop.newChapter2.Food.BaseFood;
import mygames.game.desktop.newChapter2.Food.FoodFactory;

import java.util.ArrayList;

public class SnakeGameController extends GameBeta {
    private Snake snake;
    private ActorBeta apple;
    private ActorBeta ocean;
    private ActorBeta winMessage;
    private Array<BodyPart> bodyParts;

    private BaseFood Food;
    private static final float MOVE_TIME = 0.09f;
    private float timer;
    private GameStates state = GameStates.PLAYING;
    private FoodFactory foodFactory;

    private ArrayList<Rock> rocks;

    public SnakeGameController() {
    }
    @Override
    public void initialize() {
        foodFactory = new FoodFactory(rocks);
        rocks = new ArrayList<Rock>();

        this.ocean = new ActorBeta(0,0,mainStage);
        Texture texture = new Texture(Gdx.files.internal("plane.jpg"));
        this.ocean.setTexture(texture);
        this.ocean.setSize(GameConfig.width,GameConfig.height);
        this.ocean.addActorToStage();

        this.snake = new Snake(20f,20f,mainStage);
        this.snake.getHead().setTexture(new Texture(Gdx.files.internal("assetsPr/snake.png")));
        this.snake.getHead().addActorToStage();

        bodyParts = snake.getBodyParts();


        this.apple = new ActorBeta(380, 380, mainStage);
        this.apple.setTexture(new Texture(Gdx.files.internal("strawberry.png")));
        this.apple.setSize(20f,20f);
        this.apple.addActorToStage();

        // bottom left
        rocks.add(new Rock(120,100,mainStage));
        rocks.add(new Rock(150,100,mainStage));
        rocks.add(new Rock(180,100,mainStage));

        rocks.add(new Rock(120,130,mainStage));
        rocks.add(new Rock(120,160,mainStage));

        //bottom right
        rocks.add(new Rock(620,100,mainStage));
        rocks.add(new Rock(650,100,mainStage));
        rocks.add(new Rock(680,100,mainStage));

        rocks.add(new Rock(680,130,mainStage));
        rocks.add(new Rock(680,160,mainStage));

        //top left
        rocks.add(new Rock(120,500,mainStage));
        rocks.add(new Rock(150,500,mainStage));
        rocks.add(new Rock(180,500,mainStage));

        rocks.add(new Rock(120,440,mainStage));
        rocks.add(new Rock(120,470,mainStage));

        // top right
        rocks.add(new Rock(620,500,mainStage));
        rocks.add(new Rock(650,500,mainStage));
        rocks.add(new Rock(680,500,mainStage));

        rocks.add(new Rock(680,440,mainStage));
        rocks.add(new Rock(680,470,mainStage));


    }
    @Override
    public void update(float dt) {
        switch (state) {
            case PLAYING:
                timer += dt;
                if (timer >= MOVE_TIME) {
                    timer = 0;
                    snake.move();
                    checkCollisions();
                }

                if (snake.getHead().overlaps(this.apple)) {
                    this.apple.setPosition(GameConfig.getRandomX(), GameConfig.getRandomY());

                    snake.insertBodyPart();
                }

                break;
            case GAME_OVER:
                this.winMessage = new ActorBeta(120f,120f,mainStage);
                this.winMessage.setTexture(new Texture(Gdx.files.internal("assetsPr/Rip.png")));
                this.winMessage.setSize(250f,200f);
                this.winMessage.addActorToStage();
        }
    }
    private void checkCollisions(){
        for (BodyPart bodyPart : bodyParts){
            if (Intersector.overlaps(snake.getHead().getRectangle(),bodyPart.getRectangle())){
                System.out.println("GameOver");
                state = GameStates.GAME_OVER;
                break;
            }
        }
    }
}









