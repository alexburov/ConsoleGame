public class SwordsMan extends Unit implements IUnit
{
    public SwordsMan(int x, int y, int health)
    {
        super(x, y, health);
    }


    @Override
    public void fight(IUnit unit)
    {
            if (this.isAlive())
            {
                unit.recieveDamage(this.getDamage());
                System.out.println("Enemy recieved " + this.getDamage() + " damage");
                System.out.println("Enemy's health: " + unit.getHealth());
            }
            else
            {
                this.die();
                return;
            }
            if (unit.isAlive())
            {
                this.recieveDamage(unit.getDamage());
                System.out.println("You recieved " + unit.getDamage() + " damage");
                System.out.println("Yours health: " + this.getHealth());
            }
            else
            {
                unit.die();
                return;
            }
    }
}
