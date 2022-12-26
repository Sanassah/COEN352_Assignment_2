
import static org.junit.jupiter.api.Assertions.*;
import static pkg.main.WarehouseInventory.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pkg.main.DLLDictionary;
import pkg.main.WarehouseInventory;

import java.io.IOException;

public class QueryJUnitTest {

    @BeforeAll
    public static void setUp() throws IOException {
        createDataBase("src/main/resources/UnitTestDatabase.xlsx", "Sheet1");
    }

    @Test
    void queryTest() {
        //Index for unit price: 14 23 16 5 19 0 15 11 17 13 18 4 8 12 10 22 24 1 21 3 6 7 9 20 2
        assertEquals(0, query("unitPrice",20),"PASS");
    }
    @Test
    void queryTest2() {
        //Index for quantity in stock: 3 17 19 24 8 0 7 12 15 21 22 2 10 8 5 11 6 1 18 16 14 23 13 20 4
        assertEquals(24, query("quantityInStock",10),"PASS");
    }
}
