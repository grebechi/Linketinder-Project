package aczg.grebechi.controller

import aczg.grebechi.model.Candidato
import aczg.grebechi.model.Empresa
import aczg.grebechi.model.Vaga
import spock.lang.Specification

class MatchControllerSpec extends Specification {

    Candidato candidato
    Empresa empresa
    Vaga vaga
    MatchController controller

    // O método setup() roda antes de cada teste, preparando os dados
    def setup() {
        candidato = new Candidato(nome: "Gabriel", email: "gabriel@email.com")
        empresa = new Empresa(nome: "Acelera ZG", cnpj: "11.111.111/0001-11")
        vaga = new Vaga(id: 1, titulo: "Desenvolvedor Groovy", empresa: empresa)
        controller = new MatchController()
    }

    def "deve dar match quando o candidato curte a vaga e a empresa curte o candidato"() {
        when: "o candidato curte a vaga"
        controller.candidatoCurteVaga(candidato, vaga)

        and: "a empresa curte o candidato de volta"
        controller.empresaCurteCandidato(empresa, candidato)

        then: "o historico deve ter 1 curtida e ela deve ser um match"
        controller.historicoCurtidas.size() == 1
        controller.historicoCurtidas[0].isMatch()
    }

    def "deve suportar a empresa curtindo primeiro sem quebrar com NullPointerException"() {
        given: "que a empresa curtiu o candidato de forma anonima (antes dele curtir a vaga)"
        controller.empresaCurteCandidato(empresa, candidato)

        when: "o candidato curte uma vaga dessa mesma empresa"
        controller.candidatoCurteVaga(candidato, vaga)

        then: "nao deve lancar nenhuma excecao (NPE)"
        noExceptionThrown()

        and: "deve atualizar a curtida existente e gerar o match"
        controller.historicoCurtidas.size() == 1
        controller.historicoCurtidas[0].isMatch()
        controller.historicoCurtidas[0].vaga == vaga
    }
}