package com.empresa.rh.controller;

import com.empresa.rh.models.Funcionario;
import com.empresa.rh.repository.FuncionarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastrar-funcionario")
public class CadastrarFuncionariosController {
    private final FuncionarioRepository funcionarioRepository;

    public CadastrarFuncionariosController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario cadastrar(@RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }
}
