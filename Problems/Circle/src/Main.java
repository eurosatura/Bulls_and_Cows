class Circle {

    double radius;

    // write methods here
    public double getLength() {
        return radius * 2 * Math.PI;
    }

    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }
}