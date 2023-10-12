package filter;

import flower.Item;

public interface SearchFilter {
    boolean match(Item item);
}
