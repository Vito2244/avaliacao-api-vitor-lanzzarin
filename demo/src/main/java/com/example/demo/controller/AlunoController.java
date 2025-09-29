package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private List<String> alunos = new ArrayList<>();

    @GetMapping
    public List<String> listarAlunos() {
        return alunos;
    }

    @PostMapping
    public String adicionarAluno(@RequestBody String nome) {
        alunos.add(nome);
        return "Aluno Adicionado: " + nome;
    }

    @PutMapping("/{id}")
    public String atualizarAluno(@PathVariable int id, @RequestBody String novoNome) {
        if (id >= 0 && id < alunos.size()) {
            alunos.set(id,novoNome);
            return "Aluno Atualizado para: " + novoNome;
        }
        return "Aluno não encontrado";
    }

    @DeleteMapping("/{id}")
    public String removerAluno(@PathVariable int id) {
        if (id >= 0 && id < alunos.size()) {
            String removido = alunos.remove(id);
            return "Aluno removido: " + removido;
        }
        return "Aluno não encontrado";
    }
}
