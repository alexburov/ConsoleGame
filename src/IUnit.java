public interface IUnit
{
    int moveUp();
    int moveDown();
    int moveLeft();
    int moveRight();
    void fight(IUnit unit);
    void recieveDamage(int damage);
    void die();
    int getDamage();

    boolean isAlive();

    int getX();
    int getY();
    int getHealth();

    void setX(int newX);
    void setY(int newY);
    void setHealth(int newHealth);
}
