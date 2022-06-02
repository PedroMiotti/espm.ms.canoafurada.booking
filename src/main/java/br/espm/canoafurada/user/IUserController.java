package br.espm.canoafurada.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "service.user", url = "localhost:8084/api")
public interface IUserController {
    @GetMapping("/user")
    public List<UserDto> getAllUsers();

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable UUID id);

    @PostMapping("/user")
    public UserDto createUser(@RequestBody UserDto user);
}
