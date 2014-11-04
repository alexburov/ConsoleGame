import java.awt.*;
import java.io.IOException;

public class Map implements IMap
{
    IUnit[][] units;
    IUnit[][] previousUnits;
    @Override
    public IUnit checkPosition(int x, int y)
    {
        return this.units[x][y];
    }

    @Override
    public void printMap()
    {
        System.out.print("  0");
        for(int n = 0; n < units.length; n++)
        {
            System.out.printf("%2d ",n+1);
        }
        System.out.println();
        for (int i = 0; i < units.length; i++)
        {
            System.out.printf("%2d ",i+1);
            for (int j = 0; j < units.length; j++)
            {
                if (units[i][j] == null)
                {
                    System.out.printf("%2c ", '.');
                }
                else
                {
                    System.out.printf("%2s ", units[i][j]);
                }
            }
            System.out.print('\n');
        }
    }

    @Override
    public void addUnit(Unit unit)
    {
        this.units[unit.getY()][unit.getX()] = unit;
        clearWorld();
        this.printMap();
    }

    @Override
    public void changeUnitPosition(IUnit unit, int newX, int newY)
    {
        IUnit checkUnit = this.units[newY][newX];
        if (checkUnit == null || !checkUnit.isAlive())
        {
            IUnit previousUnit = previousUnits[unit.getY()][unit.getX()];
            updatePreviousMap();
            this.units[unit.getY()][unit.getX()] = previousUnit;
            unit.setX(newX);
            unit.setY(newY);
            this.units[newY][newX] = unit;
            this.clearWorld();
            this.printMap();
        }
        else
        {
            while (checkUnit.isAlive())
            {
                unit.fight(checkUnit);
                try
                {
                    Thread.sleep(1000);
                }
                catch (Exception ex)
                {

                }
                this.printMap();
            }
        }
    }

    @Override
    public void updatePreviousMap()
    {
        previousUnits = new IUnit[units.length][];
        for (int i = 0; i < units.length; i++)
            previousUnits[i] = units[i].clone();
    }

    public void clearWorld()
    {
        for (int i = 0; i < 40; i++)
        {
            System.out.println();
        }
    }
}
