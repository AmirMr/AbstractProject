package mygames.game.desktop.newChapter2;

public class GameConfig {
    public static final float Snake_SPEED = 15f;
    public static final float width = 800f;
    public static final float height = 600f;

    public static float getRandomX(){
        return (float)(15f + Math.random() * (width - 100f));
    }
    public static float getRandomY(){
        return (float)(15f + Math.random() * (height - 100f));
    }

}
