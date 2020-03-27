package academy.everyonecodes.Services;

import academy.everyonecodes.Data.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UUIDProvider {
    private Map<String, String> cache;

    public UUIDProvider() {
        cache = new HashMap<>();
    }

    public Patient provideUUID(Patient patient) {
        boolean isInTheCache = cache.containsKey(patient.getName());
        String patientName = patient.getName();
        if (!isInTheCache) {
            UUID uuidFromName = UUID.randomUUID();
            String uuidAsString = uuidFromName.toString();
            patient.setUuid(uuidAsString);
            cache.put(patient.getName(), patient.getUuid());
        }
        String patientUuid = cache.get(patientName);
        patient.setUuid(patientUuid);
        return patient;
    }

    public Map<String, String> getCacheSnapshot() {
        return cache;
    }

    public String findUUID(String patientName) {
        return cache.getOrDefault(patientName, null);
    }
}
