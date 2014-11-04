import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Program
{

    static Map map;
    static SwordsMan player;

    public static void main(String[] args)
    {
        createMap();
        spawnPlayer(10, 10, 100);
        SwordsMan enemy = new SwordsMan(10,5,50);
        map.addUnit(enemy);
        getPlayerMove();
    }

    static void createMap()
    {
        map = new Map();
        map.units = new IUnit[20][20];
    }

    static void spawnPlayer(int x, int y, int health)
    {
        player = new SwordsMan(x, y, health);
        map.addUnit(player);
    }

    static void getPlayerMove()
    {
        Scanner scanner = new Scanner(System.in);

        char n = scanner.next().charAt(0);
        while (n != 'q')
        {
            switch (n)
            {
                case 'w':
                {
                    map.changeUnitPosition(player, player.getX(), player.moveUp());
                    break;
                }
                case 's':
                {
                    map.changeUnitPosition(player, player.getX(), player.moveDown());
                    break;
                }
                case 'a':
                {
                    map.changeUnitPosition(player, player.moveLeft(), player.getY());
                    break;
                }
                case 'd':
                {
                    map.changeUnitPosition(player, player.moveRight(), player.getY());
                    break;
                }
            }
            n = scanner.next().charAt(0);
        }
    }
}
