package aczg.grebechi.controller

import aczg.grebechi.model.Empresa
import spock.lang.Specification

class EmpresaControllerSpec extends Specification {

    def "deve inserir uma nova empresa na lista de empresas"() {
        given: "o controlador de empresas"
        EmpresaController controller = new EmpresaController()

        and: "o tamanho inicial da lista"
        int tamanhoInicial = controller.listaEmpresas.size()

        and: "uma nova empresa"
        Empresa novaEmpresa = new Empresa(nome: "Acelera ZG", cnpj: "12.345.678/0001-00", pais: "Brasil", competenciasDesejadas: ["Java", "Groovy"])

        when: "a empresa eh adicionada a lista"
        controller.adicionarEmpresa(novaEmpresa)

        then: "a lista deve conter um elemento a mais"
        controller.listaEmpresas.size() == tamanhoInicial + 1

        and: "a empresa Acelera ZG deve estar presente na lista"
        // Aqui usei uma Closure do Groovy para buscar a empresa recém adicionada
        controller.listaEmpresas.find { it.cnpj == "12.345.678/0001-00" } != null
    }
}