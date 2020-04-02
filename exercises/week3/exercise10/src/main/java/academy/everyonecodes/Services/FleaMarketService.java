package academy.everyonecodes.Services;

import academy.everyonecodes.data.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class FleaMarketService {
    private List<Item> items;

    public FleaMarketService() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems(String itemName) {
        return items.stream()
                .filter(item -> item.getName().equals(itemName))
                .collect(toList());

    }
}
