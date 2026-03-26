import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RgbColorTest {
    RgbColor C = new RgbColor(100,150,200);
    RgbColor Cg = new RgbColor(150,150,150);
    RgbColor Ci = new RgbColor(155,105,55);

    RgbColor D = new RgbColor(25,60,75);
    RgbColor Dg = new RgbColor(53,53,53);
    RgbColor Di = new RgbColor(230,195,180);
    @Test
    void getRed() {
        assertEquals(100,C.getRed());

        assertEquals(25,D.getRed());
    }

    @Test
    void getGreen() {
        assertEquals(150,C.getGreen());

        assertEquals(60,D.getGreen());
    }

    @Test
    void getBlue() {
        assertEquals(200,C.getBlue());

        assertEquals(75,D.getBlue());
    }

    @Test
    void invert() {
        assertEquals(Ci.getRed(),C.invert().getRed());
        assertEquals(Ci.getGreen(),C.invert().getGreen());
        assertEquals(Ci.getBlue(),C.invert().getBlue());

        assertEquals(Di.getRed(),D.invert().getRed());
        assertEquals(Di.getGreen(),D.invert().getGreen());
        assertEquals(Di.getBlue(),D.invert().getBlue());

    }

    @Test
    void grayscale() {
        assertEquals(Cg.getRed(),C.grayscale().getRed());
        assertEquals(Cg.getGreen(),C.grayscale().getGreen());
        assertEquals(Cg.getBlue(),C.grayscale().getBlue());

        assertEquals(Dg.getRed(),D.grayscale().getRed());
        assertEquals(Dg.getGreen(),D.grayscale().getGreen());
        assertEquals(Dg.getBlue(),D.grayscale().getBlue());

    }

    @Test
    void isGrayscale() {
        assertEquals(C.grayscale().getRed(),Cg.getRed());
        assertEquals(C.grayscale().getGreen(),Cg.getGreen());
        assertEquals(C.grayscale().getBlue(),Cg.getBlue());

        assertEquals(D.grayscale().getRed(),Dg.getRed());
        assertEquals(D.grayscale().getGreen(),Dg.getGreen());
        assertEquals(D.grayscale().getBlue(),Dg.getBlue());
    }
}