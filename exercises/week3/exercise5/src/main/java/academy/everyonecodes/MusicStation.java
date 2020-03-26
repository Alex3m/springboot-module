package academy.everyonecodes;

import academy.everyonecodes.data.Song;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@ConfigurationProperties("music")
public class MusicStation {
    private List<Song> songs;

    void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> findAll() {
        return songs;
    }

    public List<Song> findBy(String genreName) {
        return songs.stream()
                .filter(song -> song.getGenre().equalsIgnoreCase(genreName))
                .collect(toList());
    }
}
