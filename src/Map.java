public class Map implements IMap
{
    IWorldObject[][] units;
    IWorldObject[][] previousUnits;
    @Override
    public IWorldObject checkPosition(int x, int y)
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
    public void addWorldObject(IWorldObject unit)
    {
        this.units[unit.getY()][unit.getX()] = unit;
        clearWorld();
        this.printMap();
    }

    @Override
    public void changeUnitPosition(IUnit unit, int newX, int newY)
    {
        IWorldObject checkObject = this.units[newY][newX];
        if (checkObject == null || checkObject instanceof IUnit)
        {
            if (unit.isAlive())
            {
                IUnit checkUnit = (IUnit) checkObject;
                if (checkUnit == null || !checkUnit.isAlive())
                {
                    IUnit previousUnit = (IUnit) previousUnits[unit.getY()][unit.getX()];

                    if (previousUnit != null && previousUnit.equals(unit))
                    {
                        previousUnit = null;
                    }
                    updatePreviousMap();
                    this.units[unit.getY()][unit.getX()] = (IWorldObject) previousUnit;
                    unit.setX(newX);
                    unit.setY(newY);
                    this.units[newY][newX] = (IWorldObject) unit;
                    this.clearWorld();
                    this.printMap();
                } else if (checkUnit.getTeam() != unit.getTeam() && checkUnit.getTeam() != Unit.Team.Neutral)
                {
                    while (unit.isAlive() && checkUnit.isAlive())
                    {
                        unit.fight(checkUnit);
                        this.printMap();
                        try
                        {
                            Thread.sleep(1000);
                        } catch (Exception ex)
                        {

                        }
                    }
                }
            }
        }
    }

    @Override
    public void updatePreviousMap()
    {
        previousUnits = new IWorldObject[units.length][];
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

    @Override
    public void createMap()
    {
        units = new IWorldObject[20][20];
    }

    @Override
    public void spawnPlayer(int x, int y, int health)
    {
        addWorldObject(new SwordsMan(x, y, health, Unit.Team.Player, "S"));
    }
}
