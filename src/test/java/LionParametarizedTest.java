import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionParametarizedTest {

    private String sex;
    private boolean expectedHasMane;
    private Lion lion;
    private Feline felineMock;

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    public LionParametarizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Before
    public void setUp() throws Exception {
        felineMock = mock(Feline.class);
        lion = new Lion(sex, felineMock);
    }

    @Test
    public void lionHasManeTest() {
        Assert.assertEquals("Грива есть только у самца льва", expectedHasMane, lion.hasMane());
    }
}