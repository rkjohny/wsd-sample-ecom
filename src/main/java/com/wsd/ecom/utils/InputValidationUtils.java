package com.wsd.ecom.utils;

import java.util.List;

public class InputValidationUtils {

    public static void validateId(Long id) {
        if(id == null || id <= 0) {
            throw new IllegalArgumentException("Id is null or negative");
        }
    }

    public static void validateList(List list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("List is null or size is 0");
        }
    }

    public static void validateQuantity(Integer quantity) {
        if(quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }
    }

    public static void validateString(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Invalid argument");
        }
    }
}
