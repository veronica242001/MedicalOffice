package medicaloffice.services;

import medicaloffice.entity.Doctor;
import medicaloffice.exception.DoctorNotFoundException;
import medicaloffice.repository.PersonRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DoctorServiceTest {

    @Mock
    private  PersonRepository repository;

    @InjectMocks
    private DoctorService underTest;

    @Captor
    private ArgumentCaptor<Doctor> doctorArgumentCaptor;

//    @Before   // Am pus InjectMocks deci nu mai e nevoie de metoda asta
//    public void setUp(){
//        underTest = new DoctorService(repository);
//    }


    @Test
    public void test_addDoctor_alreadyExists(){
        //given
        Doctor  doctor = Doctor.builder().lastName("Pop").build();
        Mockito.when(repository.findFirstByLastName("Pop")).thenReturn(doctor);

       //when
        Doctor result = underTest.addDoctor(doctor);

        //then
        assertNull("result should be null", result);
        verify(repository, times(1)).findFirstByLastName("Pop"); // verificam daca s-a apelat o data metoda
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void test_addDoctor_success(){
        //given
        Doctor  doctor = Doctor.builder().lastName("Pop").build();
        Mockito.when(repository.findFirstByLastName("Pop")).thenReturn(null);
        Mockito.when(repository.save(eq(doctor))).thenReturn(doctor);

        //when
        Doctor result = underTest.addDoctor(doctor);

        //then
        assertNotNull("result should not be null", result);
        assertEquals("wrong results", doctor, result);
        verify(repository).findFirstByLastName("Pop");
        verify(repository).save(doctorArgumentCaptor.capture());
        verifyNoMoreInteractions(repository);

        assertEquals("wrong capture value", doctor, doctorArgumentCaptor.getValue());
    }

    @Test
    public void test_findAll_succes(){
        //given
        when(repository.findAll()).thenReturn( new LinkedList<>());

        //when
        List<Doctor> result = underTest.findAll();

        //then
        assertNotNull("result should not be null", result);
        //assertEquals("wrong list size", 0, result.size());
        assertTrue("wrong list size", result.isEmpty());

//        verify(repository).findAll();
//        verifyNoMoreInteractions(repository);
    }

    @Test //(expected = CustomerNotFoundException.class)
    public void test_findById_customerNotFound() {
        // given
        Long doctorId = 1L;
        when(repository.findById(doctorId)).thenReturn(Optional.empty());

        try {
            // when
            underTest.findById(doctorId);
            fail("should have failed");
        } catch (DoctorNotFoundException e) {
            // then
            assertEquals("wrong exception message", "Doctor not found", e.getMessage());
        }
    }
}
