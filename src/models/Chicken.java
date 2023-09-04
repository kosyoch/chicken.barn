package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chicken {

    private String name;

    private int age;

    public Chicken(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Egg layEgg(String parentName, int instanceNumber){
        return new Egg(parentName + "Chicken" + instanceNumber + "/", 0);
    }

    public boolean canLayEggs(){
        return age >= 2 && age <=4;
    }

    public boolean isDead(){
        return age >= 6;
    }
    public void increaseAge(){
        setAge(age + 1);
    }
    public Integer getInstanceNumber(){
        Pattern p = Pattern.compile("(\\d+)(?!.*\\d)");
        Matcher m = p.matcher(name);
        if(m.find()) {
           return Integer.parseInt(m.group());
        }
        return null;
    }
}
