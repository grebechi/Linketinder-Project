package aczg.grebechi.model

import spock.lang.Specification

class EmpresaSpec extends Specification {

    def "deve criar uma empresa e validar seus atributos"() {
        given: "uma nova empresa com dados via construtor nomeado"
        Empresa empresa = new Empresa(
                nome: "PastelSoft",
                cnpj: "99.999.999/0001-99",
                pais: "Brasil",
                competenciasDesejadas: ["Java", "SQL"]
        )

        expect: "os atributos devem bater com o que foi passado"
        empresa.nome == "PastelSoft"
        empresa.cnpj == "99.999.999/0001-99"
        empresa.pais == "Brasil"
        empresa.competenciasDesejadas == ["Java", "SQL"]
    }
}