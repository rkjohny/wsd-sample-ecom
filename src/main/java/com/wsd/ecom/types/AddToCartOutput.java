package com.wsd.ecom.types;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class AddToCartOutput extends AbstractOutput implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String result = "OK";
}
