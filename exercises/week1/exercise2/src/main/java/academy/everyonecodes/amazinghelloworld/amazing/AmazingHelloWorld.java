package academy.everyonecodes.amazinghelloworld.amazing;

import org.springframework.stereotype.Service;

@Service
public class AmazingHelloWorld {
    private Hello hello;
    private World world;

    public AmazingHelloWorld(Hello hello, World world) {
        this.hello = hello;
        this.world = world;
    }
    public String get(){
        return hello.get()+" "+world.get();
    }
}
