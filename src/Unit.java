abstract class Unit extends WorldObject implements IUnit
{
    public Unit(int x, int y, int health, Team team)
    {
        setX(x);
        setY(y);
        setHealth(health);
        setTeam(team);
    }


    private int health;



    public int getHealth()
    {
        return this.health;
    }

    public void setHealth(int newHealth)
    {
        this.health = newHealth;
    }

    @Override
    public int moveUp()
    {
        return this.getY() - 1;
    }

    @Override
    public int moveDown()
    {
        return this.getY() + 1;
    }

    @Override
    public int moveLeft()
    {
        return this.getX() - 1;
    }

    @Override
    public int moveRight()
    {
        return this.getX() + 1;
    }

    @Override
    public void decreaseHealth(int damage)
    {
        int currentHealth = this.getHealth();
        this.setHealth(currentHealth-damage);
    }

    @Override
    public boolean isAlive()
    {
        if (this.getHealth() > 0)
            return true;
        else
        {
            return false;
        }
    }

    @Override
    public void die()
    {
        this.setCharacter('x');
    }



    @Override
    public int getDamage()
    {
        return 10 + (this.getHealth()/4);
    }


}
