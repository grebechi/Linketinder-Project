package aczg.grebechi.controller

import aczg.grebechi.model.Candidato

class CandidatoController {
    List<Candidato> listaCandidatos = []

    CandidatoController() {
        listaCandidatos.add(new Candidato(nome: "Luiz", email: "luiz@email.com", cpf: "111.111.111-11", idade: 25, estado: "GO", cep: "74000-000", descricao: "Desenvolvedor Backend", competencias: ["Groovy", "Java", "SQL"]))
        listaCandidatos.add(new Candidato(nome: "Ana", email: "ana@email.com", cpf: "222.222.222-22", idade: 30, estado: "SP", cep: "01000-000", descricao: "Engenheira de Software", competencias: ["Python", "Django", "Angular"]))
        listaCandidatos.add(new Candidato(nome: "Carlos", email: "carlos@email.com", cpf: "333.333.333-33", idade: 22, estado: "MG", cep: "30000-000", descricao: "Dev Front-end", competencias: ["Typescript", "React", "CSS"]))
        listaCandidatos.add(new Candidato(nome: "Beatriz", email: "bia@email.com", cpf: "444.444.444-44", idade: 28, estado: "RJ", cep: "20000-000", descricao: "Especialista em Dados", competencias: ["Python", "SQL", "Machine Learning"]))
        listaCandidatos.add(new Candidato(nome: "João", email: "joao@email.com", cpf: "555.555.555-55", idade: 35, estado: "PR", cep: "80000-000", descricao: "Arquiteto de Sistemas", competencias: ["Java", "Spring Framework", "AWS"]))
    }

    void listarCandidatos() {
        println "--- LISTA DE CANDIDATOS ---"
        listaCandidatos.each { candidato ->
            println candidato.toString()
        }
    }

    void adicionarCandidato(Candidato novoCandidato) {
        listaCandidatos.add(novoCandidato)
        println "Candidato ${novoCandidato.nome} cadastrado com sucesso!"
    }
}
