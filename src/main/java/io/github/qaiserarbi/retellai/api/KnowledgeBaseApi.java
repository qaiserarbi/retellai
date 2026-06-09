package io.github.qaiserarbi.retellai.api;

import io.github.qaiserarbi.retellai.model.knowledgebase.KnowledgeBaseResponse;
import io.github.qaiserarbi.retellai.model.knowledgebase.KnowledgeBaseTextSource;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

/**
 * HTTP interface for the Retell AI Knowledge Base API.
 */
@HttpExchange(accept = "application/json", contentType = "application/json")
public interface KnowledgeBaseApi {

    /**
     * Create a new knowledge base. Sent as multipart/form-data.
     *
     * @param knowledgeBaseName  name of the knowledge base (required)
     * @param knowledgeBaseTexts texts to add to the knowledge base
     * @param knowledgeBaseUrls  URLs to be scraped and added
     * @param knowledgeBaseFiles files to add (each part is a binary file)
     * @param enableAutoRefresh  whether to enable auto refresh for the urls
     * @param maxChunkSize       maximum number of characters per chunk
     * @param minChunkSize       minimum number of characters per chunk
     * @return the created knowledge base
     */
    @PostExchange(value = "/create-knowledge-base", contentType = MediaType.MULTIPART_FORM_DATA_VALUE)
    KnowledgeBaseResponse createKnowledgeBase(
        @RequestPart("knowledge_base_name") String knowledgeBaseName,
        @RequestPart(value = "knowledge_base_texts", required = false) List<KnowledgeBaseTextSource> knowledgeBaseTexts,
        @RequestPart(value = "knowledge_base_urls", required = false) List<String> knowledgeBaseUrls,
        @RequestPart(value = "knowledge_base_files", required = false) List<Resource> knowledgeBaseFiles,
        @RequestPart(value = "enable_auto_refresh", required = false) Boolean enableAutoRefresh,
        @RequestPart(value = "max_chunk_size", required = false) Integer maxChunkSize,
        @RequestPart(value = "min_chunk_size", required = false) Integer minChunkSize
    );

    /**
     * Retrieve an existing knowledge base.
     *
     * @param knowledgeBaseId the knowledge base id
     * @return the knowledge base
     */
    @GetExchange("/get-knowledge-base/{knowledge_base_id}")
    KnowledgeBaseResponse getKnowledgeBase(@PathVariable("knowledge_base_id") String knowledgeBaseId);

    /**
     * List all knowledge bases.
     *
     * @return the list of knowledge bases
     */
    @GetExchange("/list-knowledge-bases")
    List<KnowledgeBaseResponse> listKnowledgeBases();

    /**
     * Delete an existing knowledge base.
     *
     * @param knowledgeBaseId the knowledge base id to delete
     */
    @DeleteExchange("/delete-knowledge-base/{knowledge_base_id}")
    void deleteKnowledgeBase(@PathVariable("knowledge_base_id") String knowledgeBaseId);

    /**
     * Add sources to an existing knowledge base. Sent as multipart/form-data.
     *
     * @param knowledgeBaseId    the knowledge base id to add sources to
     * @param knowledgeBaseTexts texts to add to the knowledge base
     * @param knowledgeBaseUrls  URLs to be scraped and added
     * @param knowledgeBaseFiles files to add (each part is a binary file)
     * @return the updated knowledge base
     */
    @PostExchange(value = "/add-knowledge-base-sources/{knowledge_base_id}", contentType = MediaType.MULTIPART_FORM_DATA_VALUE)
    KnowledgeBaseResponse addKnowledgeBaseSources(
        @PathVariable("knowledge_base_id") String knowledgeBaseId,
        @RequestPart(value = "knowledge_base_texts", required = false) List<KnowledgeBaseTextSource> knowledgeBaseTexts,
        @RequestPart(value = "knowledge_base_urls", required = false) List<String> knowledgeBaseUrls,
        @RequestPart(value = "knowledge_base_files", required = false) List<Resource> knowledgeBaseFiles
    );

    /**
     * Delete a single source from a knowledge base.
     *
     * @param knowledgeBaseId the knowledge base id to delete the source from
     * @param sourceId        the source id to delete
     * @return the updated knowledge base
     */
    @DeleteExchange("/delete-knowledge-base-source/{knowledge_base_id}/source/{source_id}")
    KnowledgeBaseResponse deleteKnowledgeBaseSource(
        @PathVariable("knowledge_base_id") String knowledgeBaseId,
        @PathVariable("source_id") String sourceId
    );
}
