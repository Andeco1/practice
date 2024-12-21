public class Circle implements Comparable<Circle>{
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    public int compareTo(Circle o) {
        if(this.getRadius() >= o.getRadius()){
            return 1;
        }
        return -1;
    }
}
