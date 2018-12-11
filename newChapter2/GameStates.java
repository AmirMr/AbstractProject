package mygames.game.desktop.newChapter2;

public enum GameStates {
    READY, PLAYING, GAME_OVER;

    public boolean isPlaying(){return  this == PLAYING;}
    public boolean isGameOver(){return  this == GAME_OVER;}

}
