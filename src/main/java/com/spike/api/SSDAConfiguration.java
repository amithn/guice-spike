package com.spike.api;

import com.yammer.dropwizard.config.Configuration;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Author: Amith Nambiar<amith.nmbr@gmail.com>
 * Date: 2/19/14
 */
public class SSDAConfiguration  extends Configuration {

    @NotEmpty
    @JsonProperty
    private String template;

    @NotEmpty
    @JsonProperty
    private String defaultName = "Stranger";

    public String getTemplate() {
        return template;
    }

    public String getDefaultName() {
        return defaultName;
    }

}
