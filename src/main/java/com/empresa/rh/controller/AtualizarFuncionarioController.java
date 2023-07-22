package com.empresa.rh.controller;

import com.empresa.rh.models.Funcionario;
import com.empresa.rh.repository.FuncionarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atualizar-funcionario")
public class AtualizarFuncionarioController {

    private final FuncionarioRepository funcionarioRepository;

    public AtualizarFuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @PutMapping("/{funcionarioId}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Long funcionarioId, @RequestBody Funcionario funcionario){
        if (!funcionarioRepository.existsById(funcionarioId)){
            return ResponseEntity.notFound().build();
        }

        funcionario.setId(funcionarioId);
        Funcionario funcionarioAtualizado = funcionarioRepository.save(funcionario);

        return ResponseEntity.ok(funcionarioAtualizado);
    }
}
