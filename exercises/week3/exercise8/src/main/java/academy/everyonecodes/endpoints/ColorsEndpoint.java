package academy.everyonecodes.endpoints;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/colors")
public class ColorsEndpoint {
    private Set<String> colors;

    public ColorsEndpoint() {
        colors = new HashSet<>();
    }

    @GetMapping
    Set<String> getColors() {
        return colors;
    }

    @GetMapping("/{name}")
    String getColor(@PathVariable String name) {
        name = name.toLowerCase();
        if (colors.contains(name)) {
            return name;
        }
        return "The color is not available in the app";
    }

    @PostMapping
    Set<String> postColors(@RequestBody String color) {
        color = color.toLowerCase();
        colors.add(color);
        return colors;
    }

    @PutMapping("/{target}")
    String putColor(@PathVariable String target, @RequestBody String newColor) {
        colors.remove(target);
        colors.add(newColor);
        return newColor;
    }

    @DeleteMapping
    Set<String> delete() {
        colors.clear();
        return colors;
    }

    @DeleteMapping("/{name}")
    void deleteOne(@PathVariable String name) {
        colors.remove(name);
    }

}
