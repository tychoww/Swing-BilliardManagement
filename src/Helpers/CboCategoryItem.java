package Helpers;

public class CboCategoryItem {
    private final String key;
    private final int value;

    public CboCategoryItem(String key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
