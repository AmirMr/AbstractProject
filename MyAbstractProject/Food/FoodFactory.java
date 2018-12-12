package mygames.game.desktop.MyAbstractProject.Food;

import com.badlogic.gdx.scenes.scene2d.Stage;
import mygames.game.desktop.MyAbstractProject.Rock;

import java.util.ArrayList;

public class FoodFactory {
    private BaseFood food;
    private Stage mainStage;
    private ArrayList<Rock> rocks;
    public FoodFactory(ArrayList<Rock> newRocks, Stage s){
        rocks = newRocks;
        mainStage = s;
    }
    public BaseFood makeFood(){
        int z = (int)(Math.random() * 2);
        float[] list = randomPosition();
        if (z == 0) {
            food = new BeerFood(list[0], list[1], mainStage);
        }else{
            food = new BigFood(list[0], list[1], mainStage);
        }
        return food;
    }

    public float[] randomPosition(){
        float x,y;
        int z = (int)(Math.random()*6);
        if (z == 0) {
            x = (float) Math.random() * 95 + 15;
            y = (float) Math.random() * 580 + 15;
        }else if (z==1){
            x = (float) Math.random() * 750+15;
            y = (float) Math.random() * 40 + 500;
        }else if (z==2){
            x = (float) Math.random() * 75 + 700;
            y = (float) Math.random() * 580 + 15;
        }else if (z == 3){
            x = (float) Math.random()*700 + 25;
            y = (float) Math.random() * 60 + 25;
        }else if (z==4){
            x = (float) Math.random() * 700 + 25;
            y = (float) Math.random() * 200 + 180;
        }else{
            x = (float) Math.random()*200 + 200;
            y = (float) Math.random() * 550 + 30;
        }
        float[] list = {x,y};
        return list;
    }
}













