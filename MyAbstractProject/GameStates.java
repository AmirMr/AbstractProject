package mygames.game.desktop.MyAbstractProject;

public enum GameStates {
    READY, PLAYING, GAME_OVER;

    public boolean isPlaying(){return  this == PLAYING;}
    public boolean isGameOver(){return  this == GAME_OVER;}

}
