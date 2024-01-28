import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {

    @Parameterized.Parameter
    public String sex;
    @Parameterized.Parameter(1)
    public boolean mane;

    @Parameterized.Parameters
    public static Object[][] param() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void getKittens() throws Exception {
        Feline mockFel = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, mockFel);
        Mockito.when(lion.getKittens()).thenReturn(1);
        assertEquals(lion.getKittens(), 1);
    }

    @Test
    public void doesHaveMane() throws Exception {
        Feline mockFel = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, mockFel);
        assertEquals(lion.doesHaveMane(), mane);
    }

    @Test
    public void getFood() throws Exception {
        Feline mockFel = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, mockFel);
        Mockito.when(mockFel.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> exRes = List.of("Животные", "Птицы", "Рыба");
        List<String> result = lion.getFood();
        assertEquals(result, exRes);
    }

    @Test(expected = Exception.class)
    public void getExeseptionSex() throws Exception {
        Feline fel = Mockito.mock(Feline.class);
        Lion lionFail = new Lion(sex, fel);
    }
}
