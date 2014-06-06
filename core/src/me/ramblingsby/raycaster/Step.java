package me.ramblingsby.raycaster;

public class Step {
  protected double x;
  protected double y;
  protected double height;
  protected double distance;
  protected double length2;
  protected double shading;
  protected double offset;

  public Step(double x, double y, double height, double distance, double length2, double shading, double offset) {
    this.x = x;
    this.y = y;
    this.height = height;
    this.distance = distance;
    this.length2 = length2;
    this.shading = shading;
    this.offset = offset;
  }
}
