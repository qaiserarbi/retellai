package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.common.Paginated;
import io.github.qaiserarbi.retellai.model.phone.CreatePhoneNumberRequest;
import io.github.qaiserarbi.retellai.model.phone.ImportPhoneNumberRequest;
import io.github.qaiserarbi.retellai.model.phone.PhoneNumberResponse;
import io.github.qaiserarbi.retellai.model.phone.UpdatePhoneNumberRequest;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PatchExchange;
import org.springframework.web.service.annotation.PostExchange;

/** HTTP API for managing Retell phone numbers. */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface PhoneNumberApi {

    /**
     * Create (purchase) a new phone number.
     *
     * @param request the create request
     * @return the newly created phone number
     */
    @PostExchange("/create-phone-number")
    PhoneNumberResponse createPhoneNumber(@RequestBody CreatePhoneNumberRequest request);

    /**
     * Retrieve a phone number by its E.164 identifier.
     *
     * @param phoneNumber the E.164 phone number identifier
     * @return the phone number
     */
    @GetExchange("/get-phone-number/{phone_number}")
    PhoneNumberResponse getPhoneNumber(@PathVariable("phone_number") String phoneNumber);

    /**
     * List all phone numbers.
     *
     * @return all phone numbers
     * @deprecated use {@link #listPhoneNumbersV2} instead
     */
    @Deprecated
    @GetExchange("/list-phone-numbers")
    List<PhoneNumberResponse> listPhoneNumbers();

    /**
     * List phone numbers with pagination.
     *
     * @param limit         maximum number of items to return
     * @param sortOrder     sort order for results ("ascending" or "descending")
     * @param paginationKey pagination key for fetching the next page
     * @return a paginated page of phone numbers
     */
    @GetExchange("/v2/list-phone-numbers")
    Paginated<PhoneNumberResponse> listPhoneNumbersV2(
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "sort_order", required = false) String sortOrder,
            @RequestParam(value = "pagination_key", required = false) String paginationKey);

    /**
     * Update an existing phone number.
     *
     * @param phoneNumber the E.164 phone number identifier
     * @param request     the update request
     * @return the updated phone number
     */
    @PatchExchange("/update-phone-number/{phone_number}")
    PhoneNumberResponse updatePhoneNumber(
            @PathVariable("phone_number") String phoneNumber,
            @RequestBody UpdatePhoneNumberRequest request);

    /**
     * Delete a phone number.
     *
     * @param phoneNumber the E.164 phone number identifier
     */
    @DeleteExchange("/delete-phone-number/{phone_number}")
    void deletePhoneNumber(@PathVariable("phone_number") String phoneNumber);

    /**
     * Import an existing phone number from a SIP trunk.
     *
     * @param request the import request
     * @return the imported phone number
     */
    @PostExchange("/import-phone-number")
    PhoneNumberResponse importPhoneNumber(@RequestBody ImportPhoneNumberRequest request);
}
