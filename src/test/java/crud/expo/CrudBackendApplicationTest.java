package crud.expo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CrudBackendApplicationTest {

    @Test
    void contextLoads(){

    }

    @Test
    void sampleTest(){
        int actual = 1;
        int expected = 1;
        assertEquals(actual,expected);
    }

}