import java.awt.*;
import java.io.IOException;

public interface IMap
{
    IUnit checkPosition(int x, int y);
    void printMap();
    void addUnit(Unit unit);
    void changeUnitPosition(IUnit unit, int newX, int newY) throws IOException, AWTException;
    void updatePreviousMap();
    void createMap();
    void spawnPlayer(int x, int y, int health);
}
