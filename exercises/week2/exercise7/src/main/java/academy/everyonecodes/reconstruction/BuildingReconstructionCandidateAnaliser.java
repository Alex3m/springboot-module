package academy.everyonecodes.reconstruction;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("singapore")
public class BuildingReconstructionCandidateAnaliser {
    private List<Building> buildings;

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public List<Building> findCandidates() {
        LocalDate reconstructionDateRule = LocalDate.now().minusYears(20);
        return buildings.stream()
                .filter(building -> building.isHistoric() == false)
                .filter(building -> building.getBuild().compareTo(reconstructionDateRule) < 0)
                .collect(Collectors.toList());
    }
}