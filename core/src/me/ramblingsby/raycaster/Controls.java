package me.ramblingsby.raycaster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Controls {
  protected boolean left;
  protected boolean right;
  protected boolean forward;
  protected boolean backward;

  public Controls() {
    left = right = forward = backward = false;
  }

  public void update() {
    left = right = forward = backward = false;

    if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
      left = true;
    }
    if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
      right = true;
    }
    if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
      forward = true;
    }
    if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
      backward = true;
    }

    if(Gdx.input.isTouched()) {
      if (Gdx.input.getY() < Gdx.graphics.getHeight() * 0.5) {
        forward = true;
      } else if (Gdx.input.getX() < Gdx.graphics.getWidth() * 0.5) {
        left = true;
      } else if (Gdx.input.getX() > Gdx.graphics.getWidth() * 0.5) {
        right = true;
      }
    }
  }
}
