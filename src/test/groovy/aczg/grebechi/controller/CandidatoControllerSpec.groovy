package aczg.grebechi.controller

import aczg.grebechi.model.Candidato
import spock.lang.Specification

class CandidatoControllerSpec extends Specification {

    def "deve inserir um novo candidato na lista de candidatos"() {
        given: "uma instancia do controlador que ja inicia com 5 candidatos pre-cadastrados"
        CandidatoController controller = new CandidatoController()

        and: "o tamanho inicial da lista"
        int tamanhoInicial = controller.listaCandidatos.size()

        and: "um novo candidato valido"
        Candidato novoCandidato = new Candidato(nome: "Afonso", email: "afonso@ogato.com", cpf: "999.999.999-99")

        when: "eu chamo a funcionalidade de adicionar o candidato"
        controller.adicionarCandidato(novoCandidato)

        then: "o array de candidatos deve aumentar em 1 elemento"
        controller.listaCandidatos.size() == tamanhoInicial + 1

        and: "o ultimo candidato da lista deve ser o Afonso"
        controller.listaCandidatos.last().nome == "Afonso"
        controller.listaCandidatos.last().email == "afonso@ogato.com"
    }
}