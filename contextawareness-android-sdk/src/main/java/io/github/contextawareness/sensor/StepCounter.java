package io.github.contextawareness.sensor;

import android.os.Build;

import io.github.contextawareness.core.Item;
import io.github.contextawareness.core.PStreamProvider;
import io.github.contextawareness.utils.Logging;
import io.github.contextawareness.utils.annotations.PSItem;
import io.github.contextawareness.utils.annotations.PSItemField;

/**
 * Step counter.
 */
@PSItem
public class StepCounter extends Item {

    /**
     * Rotation vector component along the x axis (x * sin(θ/2)).
     */
    @PSItemField(type = Float.class)
    public static final String STEPS = "steps";

    StepCounter(float steps) {
        this.setFieldValue(STEPS, steps);
    }

    /**
     * Provide a live stream of sensor readings from the step counter.
     * @return the provider.
     */
    public static PStreamProvider asUpdates(int sensorDelay){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return new StepCounterUpdatesProvider(sensorDelay);
        }
        else {
            Logging.warn("Step counter requires SDK version above 19.");
            return null;
        }
    }
}
