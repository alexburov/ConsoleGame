public interface IWorldObject
{
    int getX();
    int getY();
    String getCharacter();
    WorldObject.Team getTeam();

    void setX(int newX);
    void setY(int newY);
    void setCharacter(String newCharacter);
    void setTeam(WorldObject.Team team);
}
