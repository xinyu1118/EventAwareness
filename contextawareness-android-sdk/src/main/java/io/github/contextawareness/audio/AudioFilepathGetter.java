package io.github.contextawareness.audio;


import io.github.contextawareness.core.UQI;

/**
 * Get the file path of the audio in an AudioData field.
 */
class AudioFilepathGetter extends AudioProcessor<String> {

    AudioFilepathGetter(String photoField) {
        super(photoField);
    }

    @Override
    protected String processAudio(UQI uqi, AudioData audioData) {
        return audioData.getFilepath(uqi);
    }

}
