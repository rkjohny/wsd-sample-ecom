package com.wsd.ecom.dto.types;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ViewCartInput extends AbstractInput {
    private Long userId;
}
