package me.ramblingsby.raycaster;

import java.util.ArrayList;
import java.util.List;

public class Ray {
  protected Map map;
  protected double sin;
  protected double cos;
  protected List<Step> steps;

  public Ray(Map map, Step origin, double sin, double cos, double range) {
    this.steps = new ArrayList<Step>();
    this.map = map;
    this.sin = sin;
    this.cos = cos;

    this.cast(origin, range);
  }

  protected void cast(Step origin, double range) {
    Step stepX = step(sin, cos, origin.x, origin.y, false);
    Step stepY = step(cos, sin, origin.y, origin.x, true);
    Step nextStep = stepX.length2 < stepY.length2
      ? inspect(stepX, 1, 0, origin.distance, stepX.y)
      : inspect(stepY, 0, 1, origin.distance, stepY.x);

    this.steps.add(origin);
    if (nextStep.distance < range) {
      this.cast(nextStep, range);
    }
  }

  protected Step step(double rise, double run, double x, double y, boolean inverted) {
    if (run == 0) return new Step(0, 0, 0, 0, Double.POSITIVE_INFINITY, 0, 0);
    double dx = run > 0 ? Math.floor(x + 1) - x : Math.ceil(x - 1) - x;
    double dy = dx * (rise / run);
    return new Step(inverted ? y + dy : x + dx, inverted ? x + dx : y + dy, 0, 0, dx * dx + dy * dy, 0, 0);
  }

  protected Step inspect(Step step, double shiftX, double shiftY, double distance, double offset) {
    double dx = cos < 0 ? shiftX : 0;
    double dy = sin < 0 ? shiftY : 0;
    step.height = map.get(step.x - dx, step.y - dy);
    step.distance = distance + Math.sqrt(step.length2);
    if (shiftX == 1) step.shading = cos < 0 ? 2 : 0;
    else step.shading = sin < 0 ? 2 : 1;
    step.offset = offset - Math.floor(offset);
    return step;
  }
}