public class Program
{
    static Game game;
    public static void main(String[] args) throws InterruptedException
    {
        game = new Game();
        Door myDoor = new Door(3,3);
        game.map.addWorldObject(myDoor);
        game.map.addWorldObject(new Wall(4,3));
        game.map.addWorldObject(new Wall(2,3));
        game.map.addWorldObject(new Wall(4,2));
        game.map.addWorldObject(new Wall(2,2));
        game.map.addWorldObject(new Wall(4,1));
        game.map.addWorldObject(new Wall(2,1));
        game.map.addWorldObject(new Wall(3,1));




        while (true)
        {
            game.getMove();
        }
    }
}
