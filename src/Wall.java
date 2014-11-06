public class Wall extends WorldObject
{
    Wall(int x, int y)
    {
        this.setX(x);
        this.setY(y);
        this.setTeam(Team.Neutral);
        char c = '#';
        this.setCharacter(c);
    }
}
