package aczg.grebechi.model

import spock.lang.Specification

class CandidatoSpec extends Specification {

    def "deve criar um candidato e atribuir os dados corretamente"() {
        given: "um novo candidato"
        Candidato candidato = new Candidato()

        when: "eu preencho os dados do candidato"
        candidato.nome = "Gabriel"
        candidato.idade = 24
        candidato.cpf = "123.456.789-00"
        candidato.competencias = ["Groovy", "Spock"]

        then: "os dados devem estar acessiveis corretamente"
        candidato.nome == "Gabriel"
        candidato.idade == 24
        candidato.cpf == "123.456.789-00"
        candidato.competencias.size() == 2
        candidato.competencias.contains("Spock")
    }
}