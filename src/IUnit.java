public interface IUnit
{
    int moveUp();
    int moveDown();
    int moveLeft();
    int moveRight();
    void fight(IUnit unit);
    void decreaseHealth(int damage);
    void die();


    boolean isAlive();

    Unit.Team getTeam();
    int getDamage();
    int getX();
    int getY();
    int getHealth();

    void setTeam(Unit.Team newTeam);
    void setX(int newX);
    void setY(int newY);
    void setHealth(int newHealth);
}
