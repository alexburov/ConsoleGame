public class Door extends WorldObject
{
    Door(int x, int y)
    {
        this.setX(x);
        this.setY(y);
        this.setTeam(Team.Neutral);
        this.setCharacter('8');
    }
}
