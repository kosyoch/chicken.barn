package repositories;

import models.Egg;

import java.util.*;

public class EggRepositoryImpl implements EggRepository<Egg>{
    private List<Egg> eggs;

    public EggRepositoryImpl() {
        this.eggs = new ArrayList<>();
    }

    @Override
    public List<Egg> getEggList() {
        return eggs;
    }

    @Override
    public void addEgg(Egg egg) {
        eggs.add(egg);
    }

    @Override
    public void removeEgg(Egg egg) {
        eggs.remove(egg);
    }

    @Override
    public Integer getCount() {
        return eggs.size();
    }
}
