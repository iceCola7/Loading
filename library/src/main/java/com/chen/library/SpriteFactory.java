package com.chen.library;

import com.chen.library.sprite.Sprite;
import com.chen.library.style.ChasingDots;
import com.chen.library.style.Circle;
import com.chen.library.style.CubeGrid;
import com.chen.library.style.DoubleBounce;
import com.chen.library.style.FadingCircle;
import com.chen.library.style.FoldingCube;
import com.chen.library.style.MultiplePulse;
import com.chen.library.style.MultiplePulseRing;
import com.chen.library.style.Pulse;
import com.chen.library.style.PulseRing;
import com.chen.library.style.RotatingCircle;
import com.chen.library.style.RotatingPlane;
import com.chen.library.style.ThreeBounce;
import com.chen.library.style.WanderingCubes;
import com.chen.library.style.Wave;

/**
 * Created by chen.
 */
public class SpriteFactory {

    public static Sprite create(Style style) {
        Sprite sprite = null;
        switch (style) {
            case ROTATING_PLANE:
                sprite = new RotatingPlane();
                break;
            case DOUBLE_BOUNCE:
                sprite = new DoubleBounce();
                break;
            case WAVE:
                sprite = new Wave();
                break;
            case WANDERING_CUBES:
                sprite = new WanderingCubes();
                break;
            case PULSE:
                sprite = new Pulse();
                break;
            case CHASING_DOTS:
                sprite = new ChasingDots();
                break;
            case THREE_BOUNCE:
                sprite = new ThreeBounce();
                break;
            case CIRCLE:
                sprite = new Circle();
                break;
            case CUBE_GRID:
                sprite = new CubeGrid();
                break;
            case FADING_CIRCLE:
                sprite = new FadingCircle();
                break;
            case FOLDING_CUBE:
                sprite = new FoldingCube();
                break;
            case ROTATING_CIRCLE:
                sprite = new RotatingCircle();
                break;
            case MULTIPLE_PULSE:
                sprite = new MultiplePulse();
                break;
            case PULSE_RING:
                sprite = new PulseRing();
                break;
            case MULTIPLE_PULSE_RING:
                sprite = new MultiplePulseRing();
                break;
            default:
                break;
        }

        return sprite;
    }

}
