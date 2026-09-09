package aczg.grebechi.controller

import aczg.grebechi.model.Empresa

class EmpresaController {
    List<Empresa> listaEmpresas = []

    EmpresaController() {
        listaEmpresas.add(new Empresa(nome: "Arroz-Gostoso", email: "rh@arrozgostoso.com", cnpj: "11.111.111/0001-11", pais: "Brasil", estado: "GO", cep: "74000-000", descricao: "Maior produtora de arroz", competenciasDesejadas: ["Java", "Groovy", "SQL"]))
        listaEmpresas.add(new Empresa(nome: "Império do Boliche", email: "vagas@boliche.com", cnpj: "22.222.222/0001-22", pais: "Brasil", estado: "SP", cep: "01000-000", descricao: "Rede de entretenimento", competenciasDesejadas: ["Python", "Typescript", "React"]))
        listaEmpresas.add(new Empresa(nome: "Tech Solutions", email: "tech@solutions.com", cnpj: "33.333.333/0001-33", pais: "Brasil", estado: "MG", cep: "30000-000", descricao: "Fábrica de software", competenciasDesejadas: ["Spring Framework", "Angular", "Java"]))
        listaEmpresas.add(new Empresa(nome: "Data Corp", email: "hr@datacorp.com", cnpj: "44.444.444/0001-44", pais: "EUA", estado: "CA", cep: "90001", descricao: "Análise de dados massivos", competenciasDesejadas: ["Python", "Machine Learning"]))
        listaEmpresas.add(new Empresa(nome: "Z-Gamer", email: "jobs@zgamer.com", cnpj: "55.555.555/0001-55", pais: "Brasil", estado: "RJ", cep: "20000-000", descricao: "Estúdio de jogos", competenciasDesejadas: ["C#", "Unity", "C++"]))
    }

    void listarEmpresas() {
        println "--- LISTA DE EMPRESAS ---"
        listaEmpresas.each { empresa ->
            println empresa.toString()
        }
    }

    void adicionarEmpresa(Empresa novaEmpresa) {
        listaEmpresas.add(novaEmpresa)
        println "Empresa ${novaEmpresa.nome} cadastrada com sucesso!"
    }
}
