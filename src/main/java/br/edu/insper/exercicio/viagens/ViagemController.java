package br.edu.insper.exercicio.viagens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viagens")
public class ViagemController {

    @Autowired
    private ViagemService viagemService;

    // listar todas as viagens - qualquer usuário autenticado
    @GetMapping
    public List<Viagem> getViagens() {
        return viagemService.getViagens();
    }

    // criar viagem - qualquer usuário autenticado (front-end já controla se está logado)
    @PostMapping
    public Viagem createViagem(@RequestBody Viagem viagem) {
        return viagemService.createViagem(viagem);
    }

    // excluir viagem - somente ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteViagem(@PathVariable Integer id) {
        viagemService.deleteViagem(id);
    }

    @GetMapping("/{id}")
    public Viagem getViagem(@PathVariable Integer id) {
        return viagemService.getViagem(id);
    }
}
