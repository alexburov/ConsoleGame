abstract class Unit implements IUnit
{
    public Unit(int x, int y, int health)
    {
        setX(x);
        setY(y);
        setHealth(health);
        character = "S";
    }

    private int x, y;

    private int health;

    private String character;

    public int getX()
    {
        return this.x;
    }

    public void setX(int newX)
    {
        this.x = newX;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int newY)
    {
        this.y = newY;
    }

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

    public boolean isAlive()
    {
        if (this.getHealth() > 0)
            return true;
        else
        {
            return false;
        }
    }

    public void die()
    {
        this.character = "x";
    }

    @Override
    public String toString()
    {
        return this.character;
    }

    public int getDamage()
    {
        return 10 + (this.getHealth()/4);
    }
}
