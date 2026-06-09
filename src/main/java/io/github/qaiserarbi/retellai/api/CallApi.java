package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.call.CreatePhoneCallRequest;
import io.github.qaiserarbi.retellai.model.call.CreateWebCallRequest;
import io.github.qaiserarbi.retellai.model.call.ListCallsRequest;
import io.github.qaiserarbi.retellai.model.call.RegisterPhoneCallRequest;
import io.github.qaiserarbi.retellai.model.call.UpdateCallMetadataRequest;
import io.github.qaiserarbi.retellai.model.call.UpdateLiveCallRequest;
import io.github.qaiserarbi.retellai.model.call.UpdateLiveCallResponse;
import io.github.qaiserarbi.retellai.model.call.V2CallResponse;
import io.github.qaiserarbi.retellai.model.call.V2PhoneCallResponse;
import io.github.qaiserarbi.retellai.model.call.V2WebCallResponse;
import io.github.qaiserarbi.retellai.model.call.V3CallResponse;
import io.github.qaiserarbi.retellai.model.call.V3ListCallsRequest;
import io.github.qaiserarbi.retellai.model.common.Paginated;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PatchExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

/** HTTP interface for Retell call operations. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface CallApi {

    /** Create a new outbound phone call. */
    @PostExchange("/v2/create-phone-call")
    V2PhoneCallResponse createPhoneCall(@RequestBody CreatePhoneCallRequest request);

    /** Create a new web call. */
    @PostExchange("/v2/create-web-call")
    V2WebCallResponse createWebCall(@RequestBody CreateWebCallRequest request);

    /** Register a new phone call for custom telephony. */
    @PostExchange("/v2/register-phone-call")
    V2PhoneCallResponse registerPhoneCall(@RequestBody RegisterPhoneCallRequest request);

    /** Retrieve details of a specific call. */
    @GetExchange("/v2/get-call/{call_id}")
    V2CallResponse getCall(@PathVariable("call_id") String callId);

    /**
     * Retrieve call details (deprecated). Returns a bare array of calls.
     *
     * @deprecated use {@link #listCallsV3(V3ListCallsRequest)} instead.
     */
    @Deprecated
    @PostExchange("/v2/list-calls")
    List<V2CallResponse> listCalls(@RequestBody ListCallsRequest request);

    /** List calls with unified cursor pagination response. */
    @PostExchange("/v3/list-calls")
    Paginated<V3CallResponse> listCallsV3(@RequestBody V3ListCallsRequest request);

    /** Update metadata and data storage settings for an existing call. */
    @PatchExchange("/v2/update-call/{call_id}")
    V2CallResponse updateCallMetadata(
            @PathVariable("call_id") String callId,
            @RequestBody UpdateCallMetadataRequest request);

    /** Update an ongoing call at runtime. */
    @PatchExchange("/v2/update-live-call/{call_id}")
    UpdateLiveCallResponse updateLiveCall(
            @PathVariable("call_id") String callId,
            @RequestBody UpdateLiveCallRequest request);

    /** Delete a specific call and its associated data. */
    @DeleteExchange("/v2/delete-call/{call_id}")
    void deleteCall(@PathVariable("call_id") String callId);

    /** Stop an ongoing call. */
    @PostExchange("/v2/stop-call/{call_id}")
    void stopCall(@PathVariable("call_id") String callId);

    /** Rerun post-call analysis for a specific call. */
    @PutExchange("/rerun-call-analysis/{call_id}")
    V2CallResponse rerunCallAnalysis(@PathVariable("call_id") String callId);
}
