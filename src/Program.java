import java.util.Scanner;

public class Program
{

    static Map map = new Map();
    static SwordsMan player;

    public static void main(String[] args)
    {
        map.createMap();
        map.updatePreviousMap();
        map.spawnPlayer(10,10,100);
        player = (SwordsMan)map.units[10][10];
        SwordsMan enemy = new SwordsMan(10,5,50);
        map.addUnit(enemy);
        getPlayerMove();

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
