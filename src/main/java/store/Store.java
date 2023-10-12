package store;

import java.util.ArrayList;
import java.util.List;

import filter.SearchFilter;
import flower.Item;

public class Store {
    private List<Item> items;

    public List<Item> search(SearchFilter filter) {
        List<Item> foundsitem = new ArrayList<>();
        for (Item item: items) {
            if (filter.match(item)) {
                foundsitem.add(item);
            }
        }
        return foundsitem;
    }

}


 
