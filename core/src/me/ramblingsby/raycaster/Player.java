package me.ramblingsby.raycaster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Player {
  protected double x;
  protected double y;
  protected double direction;
  protected double paces;

  protected Texture weapon;

  public Player(double x, double y, double direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
    this.paces = 0;
    this.weapon = new Texture(Gdx.files.internal("knife_hand.png"));
  }

  public void rotate(double angle) {
    this.direction = (this.direction + angle + Raycaster.CIRCLE) % (Raycaster.CIRCLE);
  }

  public void walk(double distance, Map map) {
    double dx = Math.cos(this.direction) * distance;
    double dy = Math.sin(this.direction) * distance;
    if (map.get(this.x + dx, this.y) <= 0) this.x += dx;
    if (map.get(this.x, this.y + dy) <= 0) this.y += dy;
    this.paces += distance;
  }

  public void update(Controls controls, Map map, double seconds) {
    if (controls.left) this.rotate(-Math.PI * seconds);
    if (controls.right) this.rotate(Math.PI * seconds);
    if (controls.forward) this.walk(3 * seconds, map);
    if (controls.backward) this.walk(-3 * seconds, map);
  }

  public Point toPoint() {
    return new Point(this.x, this.y);
  }
}
