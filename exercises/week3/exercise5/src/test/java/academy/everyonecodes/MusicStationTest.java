package academy.everyonecodes;

import academy.everyonecodes.data.Song;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MusicStationTest {
    @Autowired
    MusicStation musicStation;

    @Test
    void findAll() {
        List<Song> expected = List.of(new Song("name1", "genre1"), new Song("name2", "genre2"));
        List<Song> result = musicStation.findAll();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void findBy() {
    }
}