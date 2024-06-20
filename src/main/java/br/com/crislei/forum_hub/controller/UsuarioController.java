package br.com.crislei.forum_hub.controller;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("")
    @Transactional
    public ResponseEntity<String> cadastrarUsuario(@RequestBody @Valid UsuarioDto userDTO,
                                                   UriComponentsBuilder uriComponentsBuilder) {
        Long userId = usuarioService.saveUser(userDTO);
        var uri = uriComponentsBuilder.path("/usuario/{id}")
                .buildAndExpand(userId).toUri();
        return ResponseEntity.created(uri)
                .body("Usuário registrado com sucesso. Id: " + userId);
    }

    @GetMapping("")
    public ResponseEntity<Page<UsuarioIdDto>> listarUsuarios(Pageable pageable) {
        Page<UsuarioIdDto> usersPage = usuarioService.getAllUsers(pageable);
        return ResponseEntity.ok(usersPage);
    }


    @PutMapping("/{userId}")
    public ResponseEntity<String> atualizarUsuario(
            @PathVariable Long userId,
            @RequestBody UsuarioIdDto usuarioInfo) {

        usuarioService.updateUser(userId, usuarioInfo);
        return ResponseEntity.ok("Usuário atualizado com sucesso.");

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUsuarios(@PathVariable Long userId) {

        usuarioService.deleteUser(userId);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDetalhamentoDto> detalharUsuario(@PathVariable Long id) {
        Optional<UsuarioDetalhamentoDto> detalheOptional = usuarioService.detalharUsuario(id);

        return detalheOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
