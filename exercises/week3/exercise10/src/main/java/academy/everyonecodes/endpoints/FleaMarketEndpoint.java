package academy.everyonecodes.endpoints;

import academy.everyonecodes.data.Item;
import academy.everyonecodes.Services.FleaMarketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class FleaMarketEndpoint {
    private FleaMarketService fleaMarketService;

    public FleaMarketEndpoint(FleaMarketService fleaMarketService) {
        this.fleaMarketService = fleaMarketService;
    }

    @GetMapping
    List<Item> getItems(){
        return fleaMarketService.getItems();
    }
    @PostMapping
    void postItem(@RequestBody Item item){
        fleaMarketService.addItem(item);
    }
    @GetMapping("/{item}")
    List<Item> getSelectedItems(@PathVariable String item){
        return fleaMarketService.getItems(item);
    }
}
