package io.github.qaiserarbi.retellai.model.llm;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

/**
 * The parameters a function accepts, described as a JSON Schema object.
 *
 * @param type       must be "object" for a JSON Schema object.
 * @param properties map of property name to its JSON Schema definition.
 * @param required   list of names of required properties.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ToolParameter(
        String type,
        Map<String, Object> properties,
        List<String> required
) {
}
