public class Lsp {
    // Client code demonstrating substitutability
    public static void letBirdMove(Bird bird){
        bird.move();
    }
    public static void main(String[] args) {
        Bird pigeon = new Pigeon();
        Bird penguine = new Penguine();
        // Both work interchangeably via base type Bird
        letBirdMove(pigeon);
        letBirdMove(penguine);
    }
}
interface Bird{
    void move();
}
interface FlyingBird extends Bird{
    void fly();
}
interface SwimingBird extends Bird{
    void swim();
}
// Penguin subclass that cannot fly but can swim
class Penguine implements SwimingBird{

    @Override
    public void move() {
        swim();
    }

    @Override
    public void swim() {
        System.out.println("Penguine can move by swimming");
    }
}
// pigeon subclass that can fly
class Pigeon implements FlyingBird{

    @Override
    public void move() {
        fly();
    }

    @Override
    public void fly() {
        System.out.println("Pigeon can move by flying");
    }    
}
