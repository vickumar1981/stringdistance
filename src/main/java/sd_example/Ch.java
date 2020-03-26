package sd_example;

public class Ch {
    private char ch;

    private Ch(char ch) {
        this.ch = ch;
    }

    static Ch of(char ch) {
        return new Ch(ch);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Ch)) {
            return false;
        }
        Ch c = (Ch) o;
        return ch == c.ch;
    }
}
