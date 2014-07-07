import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class ItemTest extends UnitTest {

    Item item;

    @Before
    public void setup(){
      item = new Item("content");
    }

    @Test
    public void createAndSaveItem() {
      Item item = new Item("This is the todo content");
      item.save();
      assertEquals(item.content, "This is the todo content");
      assertEquals(item.isComplete, false);
    }

    @Test
    public void testIsComplete() {
      assertEquals(item.isComplete, false);
      item.isComplete = true;
      assertEquals(item.isComplete, true);
    }

    

}
