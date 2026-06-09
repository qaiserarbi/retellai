package io.github.qaiserarbi.retellai.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * A word / phrase and its pronunciation used to guide audio synthesis.
 *
 * @param word     the string of word / phrase to be annotated
 * @param alphabet the phonetic alphabet to be used
 * @param phoneme  pronunciation of the word in IPA / CMU format
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record PronunciationEntry(
        String word,
        PronunciationAlphabet alphabet,
        String phoneme
) {
}
