package repositories;

import java.util.List;

public interface EggRepository<Egg> {
    List<Egg> getEggList();
    void addEgg(Egg egg);

    void removeEgg(Egg egg);

    Integer getCount();


}
