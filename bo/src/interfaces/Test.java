package interfaces;

public class Test implements CharSequence{
    private String Words;



    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    public String StringBackWard(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String getWords() {
        return Words;
    }

    public void setWords(String words) {
        Words = words;
    }
}
