import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int count;
    private final Feline feline = new Feline();

    public FelineParameterizedTest(int count) {
        this.count = count;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {0},
                {1},
                {5},
                {10}
        };
    }

    @Test
    public void testGetKittensWithCount() {
        assertEquals(count, feline.getKittens(count));
    }
}