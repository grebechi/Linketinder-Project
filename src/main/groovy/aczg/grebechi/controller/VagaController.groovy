package aczg.grebechi.controller

import aczg.grebechi.model.Empresa
import aczg.grebechi.model.Vaga

class VagaController {
    List<Vaga> listaVagas = []
    private int contadorId = 1

    void gerarVagasIniciais(List<Empresa> empresasCadastradas) {
        if (empresasCadastradas.size() >= 2) {
            adicionarVaga(new Vaga(titulo: "Desenvolvedor Java Jr", descricao: "Atuar no backend", empresa: empresasCadastradas[0], competenciasObrigatorias: ["Java", "SQL"]))
            adicionarVaga(new Vaga(titulo: "Front-end React Pleno", descricao: "Fazer telas", empresa: empresasCadastradas[1], competenciasObrigatorias: ["React", "Typescript"]))
        }
    }

    void adicionarVaga(Vaga vaga) {
        vaga.id = contadorId++
        listaVagas.add(vaga)
    }

    void listarVagas() {
        println "--- VAGAS DISPONÍVEIS ---"
        listaVagas.each { vaga ->
            println vaga.toString()
        }
    }

    Vaga buscarVagaPorId(Integer id) {
        return listaVagas.find { it.id == id }
    }
}