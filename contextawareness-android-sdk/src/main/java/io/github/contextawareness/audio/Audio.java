package io.github.contextawareness.audio;


import io.github.contextawareness.core.Item;
import io.github.contextawareness.core.PStreamProvider;
import io.github.contextawareness.utils.annotations.PSItem;
import io.github.contextawareness.utils.annotations.PSItemField;

/**
 * An Audio item represents an audio, could be an audio record from microphone,
 * an audio file from storage, etc.
 */
@PSItem
public class Audio extends Item {

    /**
     * The timestamp of when the Audio item was generated.
     */
    @PSItemField(type = Long.class)
    public static final String TIMESTAMP = "timestamp";

    /**
     * The abstraction of audio data.
     * The value is an `AudioData` instance.
     */
    @PSItemField(type = AudioData.class)
    public static final String AUDIO_DATA = "audio_data";

    /** Low sampling duration, every 30s. */
    public static final long DURATION_LOW = 30*1000;
    /** Medium sampling duration, every 1min. */
    public static final long DURATION_MEDIUM = 60*1000;
    /** High sampling duration, every 5min. */
    public static final long DURATION_HIGH = 5*60*1000;
    /** Low sampling interval, every 1min. */
    public static final long INTERVAL_LOW = 60*1000;
    /** Medium sampling interval, every 5min. */
    public static final long INTERVAL_MEDIUM = 5*60*1000;
    /** High sampling interval, every 10min. */
    public static final long INTERVAL_HIGH = 10*60*1000;

    Audio(long timestamp, AudioData audioData) {
        this.setFieldValue(TIMESTAMP, timestamp);
        this.setFieldValue(AUDIO_DATA, audioData);
    }

    /**
     * Provide an Audio item.
     * The audio is recorded from microphone for a certain duration of time.
     * This provider requires `android.permission.RECORD_AUDIO` permission.
     *
     * @param duration the time duration of audio.
     * @return the provider.
     */
    // @RequiresPermission(value = Manifest.permission.RECORD_AUDIO)
    public static PStreamProvider record(long duration) {
        return new AudioRecorder(duration);
    }

    /**
     * Provide a live stream of Audio items.
     * The audios are recorded from microphone periodically every certain time interval,
     * and each Audio item is a certain duration of time long.
     * For example, `recordPeriodic(1000, 4000)` will record audio from 0s-1s, 5s-6s, 10s-11s, ...
     * This provider requires `android.permission.RECORD_AUDIO` permission.
     *
     * @param durationPerRecord the time duration of each audio record, in milliseconds.
     * @param interval the time interval between each two records, in milliseconds.
     * @return the provider
     */
    // @RequiresPermission(value = Manifest.permission.RECORD_AUDIO)
    public static PStreamProvider recordPeriodic(long durationPerRecord, long interval) {
        return new AudioPeriodicRecorder(durationPerRecord, interval);
    }

    /**
     * Provide all Audio items in local file system.
     * This provider requires `android.permission.READ_EXTERNAL_STORAGE` permission.
     *
     * @return the provider function.
     */
    // @RequiresPermission(value = Manifest.permission.READ_EXTERNAL_STORAGE)
    public static PStreamProvider getFromStorage() {
        return new AudioStorageProvider();
    }
}
