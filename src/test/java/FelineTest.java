import com.example.Feline;
import org.junit.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;


public class FelineTest {

    @Test
    public void felineEatMeatReturnsCorrectFood() throws Exception {
        Feline feline = new Feline();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void felineGetFamilyReturnsCorrectFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void felineGetKittensReturnsOneKittenByDefault() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());

    }

    @Test
    public void felineGetKittensReturnsCorrectNumberOfKittens() {
        Feline feline = new Feline();
        assertEquals(5, feline.getKittens(5));
    }
}


