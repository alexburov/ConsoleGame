import java.util.Scanner;

public class Game implements IGame
{
    Map map = new Map();

    SwordsMan player;
    SwordsMan enemy;

    public Game()
    {
        map.createMap();
        map.updatePreviousMap();
        map.spawnPlayer(10,10,100);
        player = (SwordsMan)map.units[10][10];
        enemy = new SwordsMan(17,5,40, Unit.Team.Enemy,"S");
        map.addWorldObject(enemy);
    }

    @Override
    public void getPlayerMove()
    {
        Scanner scanner = new Scanner(System.in);

        char n = scanner.next().charAt(0);
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
    }

    @Override
    public void getMove()
    {
        getPlayerMove();
        adjustXPosition();
        getPlayerMove();
        adjustYPosition();
    }

    @Override
    public void adjustXPosition()
    {
        if (enemy.getX() != player.getX())
        {
            if (enemy.getX() > player.getX())
                map.changeUnitPosition(enemy, enemy.moveLeft(),enemy.getY());
            else
                map.changeUnitPosition(enemy,enemy.moveRight(),enemy.getY());
        }
    }

    @Override
    public void adjustYPosition()
    {
        if (enemy.getY() != player.getY())
        {
            if (enemy.getY() > player.getY())
                map.changeUnitPosition(enemy, enemy.getX(), enemy.moveUp());
            else
                map.changeUnitPosition(enemy, enemy.getX(), enemy.moveDown());
        }
    }
}
