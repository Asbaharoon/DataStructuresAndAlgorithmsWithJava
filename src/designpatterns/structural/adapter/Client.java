package designpatterns.structural.adapter;

public class Client {

    public static void main(String args[])
    {
        Sparrow sparrow = new Sparrow();
        ToyDuck toyDuck = new PlasticToyDuck();

        // Wrap a bird in a birdAdapter so that it
        // behaves like toy duck
        ToyDuck birdAdapter = new BirdToToyDuckAdapter(sparrow);

        System.out.println("Sparrow...");
        sparrow.fly();
        sparrow.makeSound();

        System.out.println("ToyDuck...");
        toyDuck.whistle();

        // toy duck behaving like a bird
        System.out.println("BirdAdapter...");
        birdAdapter.whistle();
    }
}



// Java implementation of Adapter pattern

interface Bird
{
    // birds implement Bird interface that allows
    // them to fly and make sounds adaptee interface
    public void fly();
    public void makeSound();
}

class Sparrow implements Bird
{
    // a concrete implementation of bird
    public void fly()
    {
        System.out.println("Flying");
    }
    public void makeSound()
    {
        System.out.println("Chirp Chirp");
    }
}

interface ToyDuck
{
    // target interface
    // toyducks dont fly they just make
    // squeaking sound
    public void whistle();
}

class PlasticToyDuck implements ToyDuck
{
    public void whistle()
    {
        System.out.println("whistle sound... ");
    }
}

class BirdToToyDuckAdapter implements ToyDuck
{
    // You need to implement the interface your
    // client expects to use.
    Bird bird;
    public BirdToToyDuckAdapter(Bird bird)
    {
        // we need reference to the object we
        // are adapting
        this.bird = bird;
    }

    public void whistle()
    {
        // translate the methods appropriately
        bird.makeSound();
    }
}
