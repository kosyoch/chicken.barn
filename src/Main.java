import models.Chicken;
import models.Egg;
import models.WeekType;
import repositories.ChickenRepository;
import repositories.ChickenRepositoryImpl;
import repositories.EggRepository;
import repositories.EggRepositoryImpl;
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        ChickenRepository<Chicken> chickens = new ChickenRepositoryImpl();

        EggRepository<Egg> eggs = new EggRepositoryImpl();

        createInitialChickens(chickens);

        changeByWeek(chickens, eggs);

        printFinalInfo(chickens, eggs);

    }
    public static void createInitialChickens(ChickenRepository<Chicken> chickens) throws IOException {
        File file = new File("C:\\Users\\Kose\\Desktop\\Chickens.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String currentLine;

        while ((currentLine = bufferedReader.readLine()) != null){
            String[] tokens = currentLine.split(" ");
            chickens.add(new Chicken(tokens[0], Integer.parseInt(tokens[1])));
        }
    }
    public static void changeByWeek(ChickenRepository<Chicken> chickens, EggRepository<Egg> eggs){
        Scanner scanner = new Scanner(System.in);
        int numberOfWeeks = Integer.parseInt(scanner.nextLine());

        for (int week = 0; week < numberOfWeeks; week++) {
            String weekType = scanner.nextLine();
            Iterator<Map.Entry<Integer, Chicken>> iterator = chickens.getChickenMap().entrySet().iterator();
            while (iterator.hasNext()){

                Map.Entry<Integer, Chicken> entry = iterator.next();
                Chicken currentChicken = entry.getValue();
                currentChicken.increaseAge();
                if (currentChicken.isDead()){
                    iterator.remove();
                    continue;
                }
                if (week == 0){
                    layEggs(currentChicken,eggs, WeekType.valueOf(weekType), chickens.getInitialInstanceNumber());
                }else {
                    int currentInstanceNumber = eggs.getEggList().get(eggs.getCount() - 1).getInstanceNumber();
                    layEggs(currentChicken,eggs, WeekType.valueOf(weekType), currentInstanceNumber);
                }
            }
            hatchEggs(eggs.getEggList(), chickens.getChickenMap());
        }
    }
    public static void hatchEggs(List<Egg> eggs, Map<Integer, Chicken> chickens){
        ListIterator<Egg> iterator = eggs.listIterator();
        while(iterator.hasNext()) {
            Egg currentEgg = iterator.next();
           currentEgg.increaseAge();
            if(currentEgg.canHatch()){
                chickens.put(currentEgg.hatch().getInstanceNumber(), currentEgg.hatch());
                iterator.remove();
            }
        }
    }
    public static void layEggs(Chicken chicken, EggRepository<Egg> eggs, WeekType weekType, int instanceNumber){
        int goodWeekCycles = 3;
        if(chicken.canLayEggs()){
            switch (weekType){
                case normal -> {
                    instanceNumber +=1;
                    eggs.addEgg(chicken.layEgg(chicken.getName(), instanceNumber));
                }
                case good -> {
                    for (int j = 0; j < goodWeekCycles; j++) {
                        instanceNumber +=1;
                        eggs.addEgg(chicken.layEgg(chicken.getName(), instanceNumber));
                    }
                }
                case bad -> {
                }
            }
        }
    }
    public static void printFinalInfo(ChickenRepository<Chicken> chickens, EggRepository<Egg> eggs){
        StringBuilder stringBuilder = new StringBuilder();
        for (Chicken chicken : chickens.getChickenMap().values()) {
            stringBuilder.append(chicken.getName()).append(System.lineSeparator());
        }
        stringBuilder.append("Eggs:" + eggs.getCount());
        System.out.println(stringBuilder);
    }

}
