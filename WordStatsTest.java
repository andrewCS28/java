import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WordStatsTest {

    private WordStats ws1;
    private WordStats ws2;
    private WordStats ws3;
    private WordStats test;
    private WordStats test1;

    @BeforeEach
    void init() {
        this.ws1 = new WordStats(List.of("John","johnny", "johnny","johnny","Johnson","John","John","johnny"));
        this.ws2 = new WordStats(List.of());
        this.ws3 = new WordStats(List.of("jim","jork","jim","jork"));
    }
    @Test
    void getListOfWords() {
        assertEquals(List.of("John", "John", "John", "Johnson", "johnny", "johnny", "johnny", "johnny"),this.ws1.getListOfWords());
        assertEquals(List.of(),this.ws2.getListOfWords());
        assertEquals(List.of("jim", "jim", "jork", "jork"),this.ws3.getListOfWords());
    }

    @Test
    void count() {
        assertEquals(8,this.ws1.count());
        assertEquals(0,this.ws2.count());
        assertEquals(4,this.ws3.count());

    }

    @Test
    void testCount() {
        assertEquals(3,this.ws1.count("John"));
        assertEquals(0,this.ws2.count("hello"));
        assertEquals(2,this.ws3.count("jim"));
    }

    @Test
    void mostFrequent() {
        assertEquals(Optional.of("johnny"),this.ws1.mostFrequent());
        assertEquals(Optional.empty(),this.ws2.mostFrequent());
        assertEquals(Optional.of("jim"),this.ws3.mostFrequent());
    }

    @Test
    void merge() {
        this.test = new WordStats(List.of("John","johnny", "johnny","johnny","Johnson","John","John","johnny","jim","jork","jim","jork"));
        assertEquals(test,ws1.merge(ws3));

        this.test1 = new WordStats(List.of("jim","jork","jim","jork"));
        assertEquals(test1, ws2.merge(ws3));
    }

    @Test
    void fromString() {
    }
}