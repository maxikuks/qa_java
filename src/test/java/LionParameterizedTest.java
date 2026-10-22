import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;

    @Mock
    Feline feline;

    public LionParameterizedTest(String sex) {
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец"},
                {"Самка"}
        };
    }

    // Инициализируем мок вручную, так как Parameterized не дружит с MockitoJUnitRunner
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConstructorValidSex() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean expectedMane = "Самец".equals(sex);
        assertEquals(expectedMane, lion.doesHaveMane());
    }
}