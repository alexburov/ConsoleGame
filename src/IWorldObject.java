public interface IWorldObject
{
    int getX();
    int getY();
    char getCharacter();
    WorldObject.Team getTeam();

    void setX(int newX);
    void setY(int newY);
    void setCharacter(char newCharacter);
    void setTeam(WorldObject.Team team);
}
