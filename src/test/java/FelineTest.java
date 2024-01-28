import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    @Test
    public void getKittens() {
        Feline feline = new Feline();
        int result = feline.getKittens();
        assertEquals(result, 1);
    }

    @Test
    public void getMoreKittens() {
        Feline feline = new Feline();
        int kittensCount = 10;
        int result = feline.getKittens(kittensCount);
        assertEquals(result, kittensCount);
    }

    @Test
    public void eatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> exRes = List.of("Животные", "Птицы", "Рыба");
        List<String> result = feline.eatMeat();
        assertEquals(result, exRes);
    }

    @Test
    public void getFamily() {
        Feline feline = new Feline();
        String exRes = "Кошачьи";
        String result = feline.getFamily();
        assertEquals(result, exRes);
    }
}
