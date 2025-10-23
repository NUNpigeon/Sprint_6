import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline felineMock;


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
    public void lionConstructorThrowsExceptionForInvalidSex() {
        assertThrows(Exception.class, () -> new Lion("Неизвестный", felineMock));
    }
}
