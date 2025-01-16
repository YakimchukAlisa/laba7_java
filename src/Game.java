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
        Blinky blinky = (Blinky) ghostArray.get(0);
        Pinky pinky = (Pinky) ghostArray.get(1);
        Inky inky = (Inky) ghostArray.get(2);
        Clyde clyde = (Clyde) ghostArray.get(3);
        blinky.setAll(11, 14, 0, 3, 3);
        pinky.setAll(13, 14, 0, 3, 3);
        inky.setAll(15, 14, 0, 3, 3);
        clyde.setAll(17, 14, 0, 3, 3);

        Tile newTile = new Tile(' ');
        map.setTile(pacman.getY(), pacman.getX(), newTile);
        newTile = new Tile('P');
        map.setTile(settings.getPacmanStartY(), settings.getPacmanStartX(), newTile);
        Result.setString("");
        fruit.setIsActive(false);;
    }
}