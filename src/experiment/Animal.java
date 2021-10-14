package experiment;

public  interface Animal {
     void cry();
     String getAnimalName();
}
class Dog implements Animal {
    @Override
    public void cry() {
        System.out.println("汪汪…汪汪");
    }
    @Override
    public String getAnimalName() {
        return "狗";
    }
}
class Cat implements Animal {
    @Override
    public void cry() {
        System.out.println("喵喵...喵喵");
    }

    @Override
    public String getAnimalName() {
        return "猫";
    }
}
class Simulator {
    public void playSound(Animal animal) {
        System.out.print("现在播放" + animal.getAnimalName() + "类的声音:");
        animal.cry();
    }
}
class Application {
    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        simulator.playSound(new Dog());
        simulator.playSound(new Cat());
    }
}
