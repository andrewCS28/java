public class RgbColor {
    private final int RED;
    private final int GREEN;
    private final int BLUE;


    /**
     * Constructs a new RBGColor with the specified red, green, and blue values.
     * @param red the channel value 0-255
     * @param green the channel value 0-255
     * @param blue the channel value 0-255
     */
    public RgbColor(int red, int green, int blue){
        this.RED = red;
        this.GREEN = green;
        this.BLUE = blue;

    }

    /**
     * computes value of red channel
     * @return the red value
     */
    public int getRed(){
        return this.RED;
    }

    /**
     * computes value of green channel
     * @return the green value
     */
    public int getGreen() {
        return this.GREEN;
    }

    /**
     * determines value of blue channel
     * @return the blue value
     */
    public int getBlue() {
        return this.BLUE;
    }

    /**
     * Returns a new RGBColor instance that represents the inversion of the color
     *
     * @return the inverted color value
     */
    public RgbColor invert() {
        return new RgbColor(255-this.RED, 255-this.GREEN,255-this.BLUE);
    }

    /**
     * Converts a color to its grayscale
     * @return a new color instance that represents the grayscale color
     */
    public RgbColor grayscale() {
        int avg = (this.RED + this.BLUE + this.GREEN)/3;
        return new RgbColor(avg,avg,avg);

    }

    /**
     * Determines if the color is grayscale
     * @return true if grayscale, else false
     */
    public boolean isGrayscale(){
        return this.RED==this.BLUE&&this.BLUE==this.GREEN;
    }
}
