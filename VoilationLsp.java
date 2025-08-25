

public class VoilationLsp {
    public static void letBirdFly(Bird bird){
        bird.fly(); // this will cause error if penguine is passed.
    }
    public static void main(String[] args) {
        Bird pigeon = new Pigeon();
        Bird penguine = new Penguine();
        letBirdFly(pigeon);
        letBirdFly(penguine);
    }
}
interface  Bird{
    void fly();
}

class Pigeon implements  Bird {

    public void fly(){
        System.out.println("Pigeon can Fly");
    }
}
// Penguine subclass that voilates LSP by breaking expected behavior.
class Penguine implements Bird {

    @Override
    public void fly() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(" Penguine can not fly");
    }
    
}



