package academy.everyonecodes.logic;

import academy.everyonecodes.data.Patient;
import academy.everyonecodes.data.Treatment;
import academy.everyonecodes.repository.TreatmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
class TreatmentServiceTest {
    @Autowired
    TreatmentService service;
    @MockBean
    Nurse nurse;
    @MockBean
    TreatmentRepository repository;

    String uuid1 = "uuid1";
    Treatment expectedTreatment = new Treatment(uuid1,"test", "test","test","treated");
    Patient patient1 = new Patient(uuid1,"test", "test","test",null);
    Patient patientExpected = new Patient(uuid1,"test", "test","test","treated");

    @Test
    void getAllTreatments() {
        service.getAllTreatments();
        verify(repository).findAll();
    }

    @Test
    void getTreatmentByUuid() {
        service.getTreatmentByUuid(uuid1);
        verify(repository).findByUuid(uuid1);
    }

    @Test
    void treatPatient() {
        when(nurse.applyTreatment(patient1))
                .thenReturn(patientExpected);
        service.treatPatient(patient1);
        verify(nurse).applyTreatment(patient1);
        verify(repository).save(expectedTreatment);


    }
    @Test
    void getPatientTreatment(){
        Treatment expectedTreatment = new Treatment(uuid1, "test", "test", "test", null);
        Treatment result = service.translatePatientToTreatment(patient1);
        Assertions.assertEquals(expectedTreatment, result);
    }
}