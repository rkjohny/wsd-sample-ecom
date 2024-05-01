package com.wsd.ecom.core;

import com.wsd.ecom.dto.types.AbstractInput;
import com.wsd.ecom.dto.types.AbstractOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope("prototype")
public abstract class AbstractHelper<I extends AbstractInput, O extends AbstractOutput> {

    protected abstract void validateInput(I input, Object... args);

    protected abstract void checkPermission(I input, Object... args);

    protected abstract O executeHelper(I input, Object... args);

    public O execute(I input, Object... args) {
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
