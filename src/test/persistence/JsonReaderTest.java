package persistence;

import model.Item;
import model.ListOfItem;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ListOfItem li = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyListOfItem() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyListOfItem.json");
        try {
            ListOfItem li = reader.read();
            assertEquals("My List of Items", li.getName());
            assertEquals(0, li.getListOfItems().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralListOfItem() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralListOfItem.json");
        try {
            ListOfItem li = reader.read();
            assertEquals("My List of Items", li.getName());
            List<Item> thingies = li.getListOfItems();
            assertEquals(2, thingies.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}