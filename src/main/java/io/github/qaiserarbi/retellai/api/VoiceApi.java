package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.voice.AddCommunityVoiceRequest;
import io.github.qaiserarbi.retellai.model.voice.CloneVoiceProvider;
import io.github.qaiserarbi.retellai.model.voice.SearchCommunityVoiceRequest;
import io.github.qaiserarbi.retellai.model.voice.SearchCommunityVoiceResponse;
import io.github.qaiserarbi.retellai.model.voice.VoiceResponse;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

/** HTTP interface for the Retell AI Voice endpoints. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface VoiceApi {

    /**
     * Retrieve details of a specific voice.
     *
     * @param voiceId Unique id for the voice.
     * @return the voice details.
     */
    @GetExchange("/get-voice/{voice_id}")
    VoiceResponse getVoice(@PathVariable("voice_id") String voiceId);

    /**
     * List all voices available to the user.
     *
     * @return all voices.
     */
    @GetExchange("/list-voices")
    List<VoiceResponse> listVoices();

    /**
     * Clone a voice from audio files.
     *
     * @param files         Audio files to use for voice cloning. Up to 25 files allowed.
     * @param voiceName     Name for the cloned voice.
     * @param voiceProvider Voice provider to use for cloning.
     * @return the cloned voice.
     */
    @PostExchange(value = "/clone-voice", contentType = MediaType.MULTIPART_FORM_DATA_VALUE)
    VoiceResponse cloneVoice(
            @RequestPart("files") List<Resource> files,
            @RequestPart("voice_name") String voiceName,
            @RequestPart("voice_provider") CloneVoiceProvider voiceProvider);

    /**
     * Add a community voice to the voice library.
     *
     * @param request the add community voice request.
     * @return the added voice.
     */
    @PostExchange("/add-community-voice")
    VoiceResponse addCommunityVoice(@RequestBody AddCommunityVoiceRequest request);

    /**
     * Search for community voices from voice providers.
     *
     * @param request the search community voice request.
     * @return the matching community voices.
     */
    @PostExchange("/search-community-voice")
    SearchCommunityVoiceResponse searchCommunityVoice(@RequestBody SearchCommunityVoiceRequest request);
}
