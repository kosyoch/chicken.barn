package repositories;

import models.Chicken;

import java.util.*;

public class ChickenRepositoryImpl implements ChickenRepository<Chicken> {
    private Map<Integer, Chicken> chickens;

    public ChickenRepositoryImpl() {
        this.chickens = new LinkedHashMap<>();
    }

    @Override
    public Map<Integer, Chicken> getChickenMap() {
        return chickens;
    }

    @Override
    public void add(Chicken chicken) {
        chickens.put(chicken.getInstanceNumber(), chicken);
    }

    @Override
    public void remove(Chicken chicken) {
        chickens.remove(chicken.getInstanceNumber(), chicken);
    }

    @Override
    public Integer getInitialInstanceNumber() {
        return Collections.max(chickens.keySet());
        }




}
