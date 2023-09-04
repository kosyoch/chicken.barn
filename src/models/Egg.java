package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Egg {
    private String name;

    private int age;

    public Egg(String name, int age) {
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
    public Chicken hatch(){
        return new Chicken(this.name, 0);
    }

    public boolean canHatch(){
        return age == 2;
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

