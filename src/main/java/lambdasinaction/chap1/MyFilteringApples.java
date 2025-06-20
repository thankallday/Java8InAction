package lambdasinaction.chap1;

import java.util.*;
import java.util.function.Predicate;

public class MyFilteringApples{

    public static void main(String ... args){

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                                              new Apple(155, "green"),
                                              new Apple(120, "red"));

//        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
//        List<Apple> greenApples = filterApples(inventory, MyFilteringApples::isGreenApple);
//        System.out.println("greenApples=" + greenApples);
//
//        // [Apple{color='green', weight=155}]
//        List<Apple> heavyApples = filterApples(inventory, MyFilteringApples::isHeavyApple);
//        System.out.println("heavyApples=" + heavyApples);

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor())); //간단한 것은 굳이 메소드를 만들지 말고, 직접한다.
        System.out.println("greenApples2=" + greenApples2);

        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150); //간단한 것은 굳이 메소드를 만들지 말고, 직접한다.
        System.out.println("heavyApples2=" + heavyApples2);

        // []
        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || //간단한 것은 굳이 메소드를 만들지 말고, 직접한다.
            "brown".equals(a.getColor()));
        System.out.println("weirdApples=" + weirdApples);
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

//    public static boolean isGreenApple(Apple apple) {
//        return "green".equals(apple.getColor());
//    }
//
//    public static boolean isHeavyApple(Apple apple) {
//        return apple.getWeight() > 150;
//    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
        }
    }

}
