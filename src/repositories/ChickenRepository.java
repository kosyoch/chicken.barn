package repositories;



import java.util.Map;


public interface ChickenRepository<Chicken> {

    Map<Integer, Chicken> getChickenMap();

    void add(Chicken chicken);

    void remove(Chicken chicken);

    Integer getInitialInstanceNumber();



}
