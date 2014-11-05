public class WorldObject implements IWorldObject
{
    private int x, y;
    private Team team;

    public enum Team
    {
        Enemy,
        Player,
        Neutral;
    }

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

    @Override
    public String getCharacter()
    {
        return this.character;
    }

    public void setY(int newY)
    {
        this.y = newY;
    }

    @Override
    public void setCharacter(String newCharacter)
    {
        this.character = newCharacter;
    }

    public void setTeam(Team team)
    {
        this.team = team;
    }

    public String toString()
    {
        return this.character;
    }

    public Team getTeam()
    {
        return this.team;
    }
}
