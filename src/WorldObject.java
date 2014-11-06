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

    private char character;

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
    public char getCharacter()
    {
        return this.character;
    }

    public void setY(int newY)
    {
            this.y = newY;
    }

    @Override
    public void setCharacter(char newCharacter)
    {
        this.character = newCharacter;
    }

    public void setTeam(Team team)
    {
        this.team = team;
    }

    public String toString()
    {
        return String.valueOf(character);
    }

    public Team getTeam()
    {
        return this.team;
    }
}
