package com.wsd.ecom.core;

import com.wsd.ecom.types.AbstractInput;
import com.wsd.ecom.types.AbstractOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope("prototype")
public abstract class AbstractHelper {

    protected abstract void validateInput(AbstractInput input, Object... args);

    protected abstract void checkPermission(AbstractInput input, Object... args);

    protected abstract AbstractOutput executeHelper(AbstractInput input, Object... args);

    public AbstractOutput execute(AbstractInput input, Object... args) {
        try {
            checkPermission(input, args);
            validateInput(input, args);
            return executeHelper(input, args);
        } catch (Exception ex) {
            // Common place to error handling for all APIs
            log.error("Failed to execute API: ", ex);
            throw ex;
        }
    }
}
