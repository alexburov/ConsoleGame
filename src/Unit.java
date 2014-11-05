abstract class Unit implements IUnit
{
    public Unit(int x, int y, int health, Team team)
    {
        setX(x);
        setY(y);
        setHealth(health);
        character = "S";
        setTeam(team);

    }

    private int x, y;
    private Team team;

    public enum Team
    {
        Enemy,
        Player,
        Neutral;
    }
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

    @Override
    public void setTeam(Team team)
    {
        this.team = team;
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
        this.character = "x";
    }

    @Override
    public String toString()
    {
        return this.character;
    }

    @Override
    public int getDamage()
    {
        return 10 + (this.getHealth()/4);
    }

    public Team getTeam()
    {
        return this.team;
    }
}
