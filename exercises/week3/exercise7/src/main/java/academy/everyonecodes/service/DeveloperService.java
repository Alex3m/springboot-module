package academy.everyonecodes.service;

import academy.everyonecodes.data.Developer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Service
@ConfigurationProperties("skills")
public class DeveloperService {
    private List<Developer> developers;

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public List<Developer> findAll() {
        return developers;
    }

    public List<Developer> findBy(String skills) {
        Set<String> skillList = Set.of(skills.split(" "));
        return developers.stream()
                .filter(developer -> developer.getSkills().containsAll(skillList))
                .collect(toList());
    }
}

