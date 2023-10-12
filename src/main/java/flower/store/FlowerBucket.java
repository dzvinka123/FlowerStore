package flower.store;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucket {
    List<FlowerPack> flowerPacks = new ArrayList<>();

    public void addFlowerPack(FlowerPack flowerPack){
        flowerPacks.add(flowerPack);
    }

    public double getPrice(){
        double totalprice = 0;
        for(FlowerPack flowerPack: flowerPacks){
            totalprice += flowerPack.PackPrice();
        }
        return totalprice;
    }

}
