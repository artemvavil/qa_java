import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class CatTest {
    @Mock
    Feline homeCat;

    @Test
    public void getSound() {
        Cat cat = new Cat(homeCat);
        String catSay = cat.getSound();
        String catSayResult = "Мяу";
        assertEquals(catSayResult, catSay);
    }

    @Test
    public void getFood() throws Exception {
        Cat cat = new Cat(homeCat);
        Mockito.when(homeCat.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> exResult = List.of("Животные", "Птицы", "Рыба");
        List<String> result = cat.getFood();
        assertEquals(exResult, result);
    }
}
