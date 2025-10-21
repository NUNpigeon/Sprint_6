import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

public class LionTest {

    private Feline felineMock;

    @Before
    public void setUp() throws Exception {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        int kittens = lion.getKittens();
        assertEquals("Количество котят должно быть 1", 1, kittens);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(expectedFood, lion.getFood());
    }

    @Test
    public void testInvalidLionSex() {
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        try {
            new Lion("Неправильный пол", felineMock);
            fail("Ожидалось исключение, но оно не было выброшено.");
        } catch (Exception e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }
}
