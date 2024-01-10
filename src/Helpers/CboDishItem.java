package Helpers;

/**
 * Represents an item used in JComboBox for displaying key-value pairs.
 * This class is commonly used to store information related to dishes in a JComboBox.
 * The toString() method is overridden to provide a meaningful display in the JComboBox.
 *
 * @author Tychow
 */
public class CboDishItem {
    private final String key;
    private final int value;

    /**
     * Constructs a new CboDishItem with the specified key and value.
     *
     * @param key   The display name of the item.
     * @param value The associated value of the item.
     */
    public CboDishItem(String key, int value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Returns the display name of the item.
     *
     * @return The key associated with the item.
     */
    @Override
    public String toString() {
        return key;
    }

    /**
     * Gets the associated value of the item.
     *
     * @return The value associated with the item.
     */
    public int getValue() {
        return value;
    }
}

