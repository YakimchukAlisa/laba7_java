import org.jsfml.graphics.*;
import java.awt.*;
import java.util.List;

class Game {

    public Game() {}

    public void resetGame(Map map, Food smallFood, Food bigFood, Pacman pacman, List<Ghost> ghostArray, GameSettings settings, Text Result, Fruit fruit) {
        // сброс карты

        map.createMap();

        // сброс еды
        smallFood.setTotalFoodCount(-1);
        smallFood = new Food(242, 5, 'o');
        bigFood = new Food(4, 10, 'O');

        // сброс Pacman
        pacman.setX(settings.getPacmanStartX());
        pacman.setY(settings.getPacmanStartY());
        pacman.setNextX(settings.getPacmanStartX());
        pacman.setNextY(settings.getPacmanStartY());
        pacman.setNextDirection(3);
        pacman.setPoints(0);
        pacman.setLives(3);// Изменяем значение lives через ссылку
        pacman.setScore(0);

        // сброс призраков
        for (int i = 0; i < ghostArray.size(); i++) {
            Ghost ghost = ghostArray.get(i);

            if (ghost instanceof Pinky) {
                ghost.setAll(13, 14, 0, 3, 3);
            } else if (ghost instanceof Inky) {
                ghost.setAll(15, 14, 0, 3, 3);
            } else if (ghost instanceof Clyde) {
                ghost.setAll(17, 14, 0, 3, 3);
            } else if(ghost instanceof Ghost) {
                    ghost.setAll(11, 14, 0, 3, 3);
                }
            }


        Tile newTile = new Tile(' ');
        map.setTile(pacman.getY(), pacman.getX(), newTile);
        newTile = new Tile('P');
        map.setTile(settings.getPacmanStartY(), settings.getPacmanStartX(), newTile);
        Result.setString("");
        fruit.setIsActive(false);;
    }
}