package com.mandalrupesh.authentication_service.jwt.auth;

import com.mandalrupesh.authentication_service.jwt.user.Role;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register-user")
  public ResponseEntity<AuthenticationResponse> registerUser(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request, Role.USER));
  }

  @PostMapping("/register-seller")
  public ResponseEntity<AuthenticationResponse> registerSeller(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request,Role.SELLER));
  }

  @PostMapping("/register-delivery-boy")
  public ResponseEntity<AuthenticationResponse> registerDeliveryBoy(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request,Role.DELIVERY_BOY));
  }

  @PostMapping("/register-franchise")
  public ResponseEntity<AuthenticationResponse> registerFranchise(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request,Role.FRANCHISE));
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }


}
