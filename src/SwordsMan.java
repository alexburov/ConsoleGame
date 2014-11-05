public class SwordsMan extends Unit implements IUnit
{
    public SwordsMan(int x, int y, int health, Team team)
    {
        super(x, y, health, team);
    }


    @Override
    public void fight(IUnit unit)
    {
        if (this.isAlive())
        {
            unit.decreaseHealth(this.getDamage());
            System.out.println("Enemy recieved " + this.getDamage() + " damage");
            System.out.println("Enemy's health: " + unit.getHealth());
        }
        if (unit.isAlive())
        {
            this.decreaseHealth(unit.getDamage());
            System.out.println("You recieved " + unit.getDamage() + " damage");
            System.out.println("Yours health: " + this.getHealth());
        } else
        {
            unit.die();
            return;
        }
        if (!this.isAlive())
        {
            this.die();
            return;
        }
    }
}
