package aczg.grebechi.controller

import aczg.grebechi.model.Candidato
import aczg.grebechi.model.Curtida
import aczg.grebechi.model.Empresa
import aczg.grebechi.model.Vaga

class MatchController {
    List<Curtida> historicoCurtidas = []

    void candidatoCurteVaga(Candidato candidato, Vaga vaga) {
        Curtida curtida = historicoCurtidas.find { it.candidato.email == candidato.email && it.vaga.id == vaga.id }

        if (!curtida) {
            curtida = new Curtida(candidato: candidato, vaga: vaga, empresa: vaga.empresa)
            historicoCurtidas.add(curtida)
        }

        curtida.candidatoCurtiu = true
        verificarMatch(curtida)
    }

    void empresaCurteCandidato(Empresa empresa, Candidato candidato) {
        Curtida curtida = historicoCurtidas.find { it.candidato.email == candidato.email && it.empresa.cnpj == empresa.cnpj }

        if (!curtida) {
            curtida = new Curtida(candidato: candidato, empresa: empresa)
            historicoCurtidas.add(curtida)
        }

        curtida.empresaCurtiu = true
        verificarMatch(curtida)
    }

    private void verificarMatch(Curtida curtida) {
        if (curtida.isMatch()) {
            println "\n========================================="
            println "DEU MATCH!"
            println " O candidato ${curtida.candidato.nome} e a empresa ${curtida.empresa.nome} deram match!"
            println " Eles já podem conversar e trocar informações."
            println "=========================================\n"
        }
    }

    void listarMatches() {
        println "--- MATCHES OCORRIDOS ---"
        List<Curtida> matches = historicoCurtidas.findAll { it.isMatch() }
        if (matches.isEmpty()) {
            println "Nenhum match aconteceu ainda..."
        } else {
            matches.each { match ->
                println " ${match.candidato.nome} <---> ${match.empresa.nome} (Vaga: ${match.vaga?.titulo ?: 'Geral'})"
            }
        }
    }
}