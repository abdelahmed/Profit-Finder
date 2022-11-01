package persistence;

import model.ListOfItem;
import model.Item;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            ListOfItem li = new ListOfItem("My List of Items");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyListOfItem() {
        try {
            ListOfItem li = new ListOfItem("My work room");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyListOfItem.json");
            writer.open();
            writer.write(li);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyListOfItem.json");
            li = reader.read();
            assertEquals("My work room", li.getName());
            assertEquals(0, li.getListOfItems().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralListOfItem() {
        try {
            ListOfItem li = new ListOfItem("My List of Items");
            li.addItem(new Item("apple",2,5,90));
            li.addItem(new Item("banana", 3,5,100));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralListOfItem.json");
            writer.open();
            writer.write(li);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralListOfItem.json");
            li = reader.read();
            assertEquals("My List of Items", li.getName());
            List<Item> items = li.getListOfItems();
            assertEquals(2, items.size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}