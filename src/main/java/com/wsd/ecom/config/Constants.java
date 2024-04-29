package com.wsd.ecom.config;

/**
 * Application constants.
 */
public final class Constants {

    public static final String LOGIN_REGEX = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$";

    public static final String DEFAULT_LANGUAGE = "en";
    public static final String SYSTEM = "system";

    public static final int MAX_LOGIN_LENGTH = 50;

    public static final int MAX_PASSWORD_LENGTH = 60;
    public static final int MAX_EMAIL_LENGTH = 100;

    public static final int MAX_FIRSTNAME_LASTNAME_LENGTH = 50;

    public static final int MAX_ITEM_NAME_LENGTH = 50;

    private Constants() {}
}
