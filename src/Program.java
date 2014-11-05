public class Program
{
    static Game game;
    public static void main(String[] args) throws InterruptedException
    {
        game = new Game();
        Door myDoor = new Door(3,3);
        game.map.addWorldObject(myDoor);

        while (true)
        {
            game.getMove();
        }
    }
}
