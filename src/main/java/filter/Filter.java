package filter;

import flower.Flower;
import flower.FlowerBucket;
import flower.FlowerColor;
import flower.FlowerPack;
import flower.FlowerType;
import flower.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Filter implements SearchFilter {
    private List<Flower> flowers = new ArrayList<>();
    private double maxPrice;
    private double minPrice;
    private List<FlowerColor> flowerColors = new ArrayList<>();
    private List<FlowerType> flowerTypes = new ArrayList<>();

    @Override
    public boolean match(Item item) {
        if (!(item instanceof FlowerBucket)) {
            return false;
        }

        FlowerBucket flowerBucket = (FlowerBucket) item;
        List<FlowerPack> flowerPacks = flowerBucket.getFlowerPacks();

        if (flowerBucket.getPrice() < minPrice || flowerBucket.getPrice() > maxPrice) {
            return false;
        }

        for (FlowerPack flowerPack : flowerPacks) {
            Flower flower = flowerPack.getFlower();
            if (!flowers.contains(flower)) {
                return false;
            }

            if (!flowerColors.contains(flower.getColor()) && !flowerTypes.contains(flower.getFlowerType())) {
                return false;
            }
        }

        return true;
    }
}
