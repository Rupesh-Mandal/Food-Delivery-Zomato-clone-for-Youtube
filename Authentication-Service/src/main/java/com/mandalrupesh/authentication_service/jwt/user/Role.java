package com.mandalrupesh.authentication_service.jwt.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public enum Role {

  ADMIN(
          Set.of(
                  Permission.ADMIN_READ,
                  Permission.ADMIN_UPDATE,
                  Permission.ADMIN_DELETE,
                  Permission.ADMIN_CREATE,
                  Permission.FRANCHISE_READ,
                  Permission.FRANCHISE_UPDATE,
                  Permission.FRANCHISE_DELETE,
                  Permission.FRANCHISE_CREATE,
                  Permission.SELLER_READ,
                  Permission.SELLER_UPDATE,
                  Permission.SELLER_DELETE,
                  Permission.SELLER_CREATE,
                  Permission.DELIVERY_BOY_READ,
                  Permission.DELIVERY_BOY_UPDATE,
                  Permission.DELIVERY_BOY_DELETE,
                  Permission.DELIVERY_BOY_CREATE,
                  Permission.USER_READ,
                  Permission.USER_UPDATE,
                  Permission.USER_DELETE,
                  Permission.USER_CREATE
          )
  ),
  FRANCHISE(
          Set.of(
                  Permission.FRANCHISE_READ,
                  Permission.FRANCHISE_UPDATE,
                  Permission.FRANCHISE_DELETE,
                  Permission.FRANCHISE_CREATE,
                  Permission.SELLER_READ,
                  Permission.SELLER_UPDATE,
                  Permission.SELLER_DELETE,
                  Permission.SELLER_CREATE,
                  Permission.DELIVERY_BOY_READ,
                  Permission.DELIVERY_BOY_UPDATE,
                  Permission.DELIVERY_BOY_DELETE,
                  Permission.DELIVERY_BOY_CREATE
          )

  ),
  SELLER(
          Set.of(
                  Permission.SELLER_READ,
                  Permission.SELLER_UPDATE,
                  Permission.SELLER_DELETE,
                  Permission.SELLER_CREATE
          )

  ),
  DELIVERY_BOY(
          Set.of(
                  Permission.DELIVERY_BOY_READ,
                  Permission.DELIVERY_BOY_UPDATE,
                  Permission.DELIVERY_BOY_DELETE,
                  Permission.DELIVERY_BOY_CREATE
          )

  ),
  USER(
          Set.of(
                  Permission.USER_READ,
                  Permission.USER_UPDATE,
                  Permission.USER_DELETE,
                  Permission.USER_CREATE
          )

  )



  ;

  @Getter
  private final Set<Permission> permissions;

  public List<SimpleGrantedAuthority> getAuthorities() {
    var authorities = getPermissions()
            .stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toList());
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return authorities;
  }
}
