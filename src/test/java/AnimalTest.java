import com.example.Animal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalTest {

    @Test
    public void getFamilyShouldReturnCorrectMessage() {
        Animal animal = new Animal();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }

    @Test
    public void getFoodShouldThrowExceptionForInvalidAnimalKind() {
        Animal animal = new Animal();
        assertThrows(Exception.class, () -> animal.getFood("Всеядное"));
    }
}