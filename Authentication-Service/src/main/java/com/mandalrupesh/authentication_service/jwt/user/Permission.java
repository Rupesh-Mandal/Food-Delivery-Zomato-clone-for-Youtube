package com.mandalrupesh.authentication_service.jwt.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    FRANCHISE_READ("franchise:read"),
    FRANCHISE_UPDATE("franchise:update"),
    FRANCHISE_CREATE("franchise:create"),
    FRANCHISE_DELETE("franchise:delete"),

    SELLER_READ("seller:read"),
    SELLER_UPDATE("seller:update"),
    SELLER_CREATE("seller:create"),
    SELLER_DELETE("seller:delete"),

    DELIVERY_BOY_READ("delivery_boy:read"),
    DELIVERY_BOY_UPDATE("delivery_boy:update"),
    DELIVERY_BOY_CREATE("delivery_boy:create"),
    DELIVERY_BOY_DELETE("delivery_boy:delete"),

    USER_READ("user:read"),
    USER_UPDATE("user:update"),
    USER_CREATE("user:create"),
    USER_DELETE("user:delete")

    ;

    @Getter
    private final String permission;
}
