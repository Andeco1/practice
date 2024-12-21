public class NewClass implements Cloneable {
    String str;

    public NewClass(String str) {
        this.str = str;
    }

    public NewClass() {
    }

    @Override
    public NewClass clone() {
        try {
            NewClass clone = (NewClass) super.clone();
            clone.str = new String(this.str);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
