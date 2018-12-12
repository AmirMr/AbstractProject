package mygames.game.desktop.MyAbstractProject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;
import mygames.game.desktop.MyAbstractProject.Food.BaseFood;
import mygames.game.desktop.MyAbstractProject.Food.BeerFood;
import mygames.game.desktop.MyAbstractProject.Food.FoodFactory;
import mygames.game.desktop.MyAbstractProject.Food.BigFood;
import mygames.game.desktop.MyAbstractProject.StatesOfSnake.HardState;

import java.util.ArrayList;

public class SnakeGameController extends GameBeta {
    private Snake snake;
    private BaseFood apple;

    private BaseFood baseFood;
    private float timerForBaseFood=0;

    private ActorBeta ocean;
    private ActorBeta winMessage;
    private Array<BodyPart> bodyParts;
    private int count = 0;
    private static final float MOVE_TIME = 0.09f;
    private float timer;
    private GameStates state = GameStates.PLAYING;
    private FoodFactory foodFactory;
    private float timerForBeer = 0;
    private ArrayList<Rock> rocks;

    private Label label;
    private Label LabelStateChanges;
    public SnakeGameController() {
    }
    @Override
    public void initialize() {

        rocks = new ArrayList<Rock>();
        foodFactory = new FoodFactory(rocks, mainStage);
        this.ocean = new ActorBeta(0,0,mainStage);
        Texture texture = new Texture(Gdx.files.internal("plane.jpg"));
        this.ocean.setTexture(texture);
        this.ocean.setSize(GameConfig.width,GameConfig.height);
        this.ocean.addActorToStage();

        this.snake = new Snake(20f,20f,mainStage);
        this.snake.getHead().setTexture(new Texture(Gdx.files.internal("assetsPr/snake.png")));
        this.snake.getHead().addActorToStage();

        bodyParts = snake.getBodyParts();

        label = new Label("Score: ",GameBeta.labelStyle);
        label.setColor(Color.CYAN);
        label.setPosition(30,580);
        mainStage.addActor(label);


        LabelStateChanges = new Label("Timer: ",GameBeta.labelStyle);
        LabelStateChanges.setColor(Color.CYAN);
        LabelStateChanges.setPosition(740f,570f);


        //simple food
        this.apple = new BaseFood(180, 50, mainStage);
        this.apple.addActorToStage();

        // bottom left
        rocks.add(new Rock(180,100,mainStage));
        rocks.add(new Rock(120,160,mainStage));
        // random(800,100) random(120,600)
        //bottom right
        rocks.add(new Rock(620,100,mainStage));
        rocks.add(new Rock(680,160,mainStage));
        // random(800,100) random()
        //top left
        rocks.add(new Rock(180,500,mainStage));
        rocks.add(new Rock(120,440,mainStage));
        //random()
        // top right
        rocks.add(new Rock(620,500,mainStage));
        rocks.add(new Rock(680,440,mainStage));


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
                    float[] list = foodFactory.randomPosition();
                    this.apple.setPosition(list[0],list[1]);
                    count += 1;
                    label.setText("Score: " + count);

                    snake.insertBodyPart();
                }
                timerForBaseFood += dt;
                if (timerForBaseFood >= 6f){
                    baseFood = foodFactory.makeFood();
                    baseFood.addActorToStage();
                    timerForBaseFood = 0;
                }
                if (snake.getCurrentState() instanceof HardState){
                    timerForBeer -= dt;
                    LabelStateChanges.setText("Timer: "+(int)timerForBeer);
                    if (timerForBeer<0){
                        snake.setCurrentState(snake.getNormalState());
                        LabelStateChanges.remove();
                    }

                }

                if (mainStage.getActors().contains(baseFood,true) && snake.getHead().overlaps(baseFood)){
                    if (baseFood instanceof BeerFood) {
                        snake.setCurrentState(snake.getHardState());
                        timerForBeer += 20;
                        mainStage.addActor(LabelStateChanges);

                    }else if (baseFood instanceof BigFood) {
                        count += ((BigFood) baseFood).getCount();
                        ((BigFood) baseFood).getLabel().remove();
                        label.setText("Score: "+count);
                    }
                    baseFood.remove();

                }
                for (Rock rock : rocks){
                    if (snake.getHead().overlaps(rock)){
                        state = GameStates.GAME_OVER;
                    }
                }
                break;
            case GAME_OVER:
                this.winMessage = new ActorBeta(GameConfig.width/2-150,GameConfig.height/2f-100f,mainStage);
                this.winMessage.setTexture(new Texture(Gdx.files.internal("assetsPr/Rip.png")));
                this.winMessage.setSize(350f,250f);
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









