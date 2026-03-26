import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class DurationTest {
    Duration d = new Duration(4000);
    Duration e = new Duration(0,59,59);
    Duration f = new Duration("00:00:59");

    Duration d2 = new Duration(8000);
    Duration e2 = new Duration(1,59,58);
    Duration f2 = new Duration("00:01:58");

    @Test
    void getNumberOfSeconds() {
        assertEquals(4000, d.getNumberOfSeconds());
        assertEquals(3599, e.getNumberOfSeconds());
        assertEquals(59, f.getNumberOfSeconds());
    }

    @Test
    void getNumberOfMinutes() {
        assertEquals(66, d.getNumberOfMinutes());
        assertEquals(59, e.getNumberOfMinutes());
        assertEquals(0, f.getNumberOfMinutes());
    }

    @Test
    void getNumberOfHours() {
        assertEquals(1, d.getNumberOfHours());
        assertEquals(0, e.getNumberOfHours());
        assertEquals(0, f.getNumberOfHours());
    }

    @Test
    void testToString() {
        assertEquals("01:06:40", d.toString());
        assertEquals("00:59:59", e.toString());
        assertEquals("00:00:59", f.toString());
    }

    @Test
    void testEquals() {
        assertTrue("01:06:40".equals(d.toString()));
        assertTrue("00:59:59".equals(e.toString()));
        assertTrue("00:00:59".equals(f.toString()));
    }

    @Test
    void addDuration() {
        assertTrue(d2.equals(d.addDuration(d)));
        assertTrue(e2.equals(e.addDuration(e)));
        assertTrue(f2.equals(f.addDuration(f)));
    }

    @Test
    void subtractDuration() {
        assertTrue(d.equals(d2.subtractDuration(d).get()));
        assertTrue(e.equals(e2.subtractDuration(e).get()));
        assertTrue(f.equals(f2.subtractDuration(f).get()));
    }
}