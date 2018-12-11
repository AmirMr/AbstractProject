package mygames.game.desktop.newChapter2.Food;

import com.badlogic.gdx.scenes.scene2d.Stage;
import mygames.game.desktop.newChapter2.GameConfig;
import mygames.game.desktop.newChapter2.Rock;

import java.util.ArrayList;

public class FoodFactory {
    private BaseFood food;
    private ArrayList<Rock> rocks;
    public FoodFactory(ArrayList<Rock> newRocks){
        rocks = newRocks;
    }
    public float[] makeFood(Stage mainStage){
        int count;
        float[] list = new float[2];
        do {
            count = 0;
            food = new BeerFood(GameConfig.getRandomX(), GameConfig.getRandomY(), mainStage);
            for (Rock rock : rocks){
                if (rock.overlaps(food)){
                    food.remove();
                    break;
                }else {
                    count += 1;
                }
            }
        }while (count != rocks.size());
        list[0] = food.getX();
        list[1] = food.getY();
        return list;
    }
}













