import java.util.*;

public class WordStats {

    /** The frequency map, ordered lexicographically. */
    private final Map<String, Integer> freq;

    /**
     * Constructor that computes word frequencies from a list.
     * @param words The list of words to process.
     */
    public WordStats(List<String> words) {
        this.freq = new TreeMap<>();
        for (String word : words) {
            this.freq.put(word, this.freq.getOrDefault(word, 0) + 1);
        }
    }

    /**
     * Returns a list of all words, repeating each by its frequency.
     * @return List of words in lexicographical order.
     */
    public List<String> getListOfWords() {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    /**
     * Returns the total number of words in the collection.
     * @return Sum of all frequencies.
     */
    public int count() {
        int total = 0;
        for (int value : freq.values()) {
            total += value;
        }
        return total;
    }

    /**
     * Returns how many times a specific word appears.
     * @param word The word to look up.
     * @return The frequency of the word.
     */
    public int count(String word) {
        return freq.getOrDefault(word, 0);
    }

    /**
     * Finds the most frequent word in the collection.
     * @return Optional containing the most frequent word, or empty if no words.
     */
    public Optional<String> mostFrequent() {
        if (freq.isEmpty()) {
            return Optional.empty();
        }

        String bestWord = null;
        int maxFreq = -1;
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                bestWord = entry.getKey();
            }
        }
        return Optional.of(bestWord);
    }

    /**
     * Merges two WordStats objects without mutating the current one.
     * @param otherWord The other WordStats to merge.
     * @return A new WordStats object containing combined frequencies.
     */
    public WordStats merge(WordStats otherWord) {
        List<String> combined = this.getListOfWords();
        combined.addAll(otherWord.getListOfWords());
        return new WordStats(combined);
    }

    /**
     * Creates a WordStats object from a space-separated string.
     * @param s The string to parse.
     * @return A new WordStats instance.
     */
    public static WordStats fromString(String s) {
        String[] parts = s.split(" ");
        return new WordStats(Arrays.asList(parts));
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof WordStats)) {
            return false;
        }

        WordStats other = (WordStats) o;
        return this.freq.equals(other.freq);
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.freq);
    }
}