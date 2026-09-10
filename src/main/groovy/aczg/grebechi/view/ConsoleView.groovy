package aczg.grebechi.view

import aczg.grebechi.controller.CandidatoController
import aczg.grebechi.controller.EmpresaController
import aczg.grebechi.controller.MatchController
import aczg.grebechi.controller.VagaController
import aczg.grebechi.model.Candidato
import aczg.grebechi.model.Empresa
import aczg.grebechi.model.Vaga
import aczg.grebechi.util.ConsoleUtil

class ConsoleView {
    CandidatoController candidatoController = new CandidatoController()
    EmpresaController empresaController = new EmpresaController()
    VagaController vagaController = new VagaController()
    MatchController matchController = new MatchController()
    Scanner scanner = new Scanner(System.in)

    void iniciar() {
        boolean rodando = true
        vagaController.gerarVagasIniciais(empresaController.listaEmpresas)

        while (rodando) {
            ConsoleUtil.limparTela()
            ConsoleUtil.printTitulo("===================================")
            ConsoleUtil.printTitulo("   BEM-VINDO AO LINKETINDER MVP")
            ConsoleUtil.printTitulo("===================================")
            println "1. Listar Candidatos"
            println "2. Listar Empresas"
            println "3. Cadastrar Novo Candidato"
            println "4. Cadastrar Nova Empresa"
            println "5. Listar Vagas"
            println "6. Simular: Candidato curtir Vaga"
            println "7. Simular: Empresa curtir Candidato"
            println "8. Ver Matches"
            ConsoleUtil.printErro("0. Sair")
            print "\nEscolha uma opção: "

            String opcao = scanner.nextLine().trim()

            switch (opcao) {
                case "1":
                    ConsoleUtil.limparTela()
                    candidatoController.listarCandidatos()
                    ConsoleUtil.pausar(scanner)
                    break
                case "2":
                    ConsoleUtil.limparTela()
                    empresaController.listarEmpresas()
                    ConsoleUtil.pausar(scanner)
                    break
                case "3":
                    cadastrarCandidatoMenu()
                    break
                case "4":
                    cadastrarEmpresaMenu()
                    break
                case "5":
                    ConsoleUtil.limparTela()
                    vagaController.listarVagas()
                    ConsoleUtil.pausar(scanner)
                    break
                case "6":
                    menuCandidatoCurteVaga()
                    break
                case "7":
                    menuEmpresaCurteCandidato()
                    break
                case "8":
                    ConsoleUtil.limparTela()
                    matchController.listarMatches()
                    ConsoleUtil.pausar(scanner)
                    break
                case "0":
                    ConsoleUtil.limparTela()
                    ConsoleUtil.printSucesso("Obrigado por usar o Linketinder. Até logo!")
                    rodando = false
                    break
                default:
                    ConsoleUtil.printErro("Opção inválida! Tente novamente.")
                    Thread.sleep(1500) // Pausa rápida para o usuário ler o erro antes de limpar a tela
            }
        }
    }

    private void cadastrarCandidatoMenu() {
        ConsoleUtil.limparTela()
        ConsoleUtil.printTitulo("--- CADASTRO DE NOVO CANDIDATO ---")
        Candidato c = new Candidato()

        c.nome = lerStringValida("Nome: ")
        c.email = lerStringValida("Email: ")
        c.cpf = lerStringValida("CPF: ")
        c.idade = lerInteiroValido("Idade: ")
        c.estado = lerStringValida("Estado: ")
        c.cep = lerStringValida("CEP: ")
        c.descricao = lerStringValida("Descrição: ")

        String comps = lerStringValida("Competências (separadas por vírgula): ")
        c.competencias = comps.split(",").collect { it.trim() }

        candidatoController.adicionarCandidato(c)
        ConsoleUtil.printSucesso("\nCandidato ${c.nome} cadastrado com sucesso!")
        ConsoleUtil.pausar(scanner)
    }

    private void cadastrarEmpresaMenu() {
        ConsoleUtil.limparTela()
        ConsoleUtil.printTitulo("--- CADASTRO DE NOVA EMPRESA ---")
        Empresa e = new Empresa()

        e.nome = lerStringValida("Nome da Empresa: ")
        e.email = lerStringValida("Email Corporativo: ")
        e.cnpj = lerStringValida("CNPJ: ")
        e.pais = lerStringValida("País: ")
        e.estado = lerStringValida("Estado: ")
        e.cep = lerStringValida("CEP: ")
        e.descricao = lerStringValida("Descrição: ")

        String comps = lerStringValida("Competências Desejadas (separadas por vírgula): ")
        e.competenciasDesejadas = comps.split(",").collect { it.trim() }

        empresaController.adicionarEmpresa(e)
        ConsoleUtil.printSucesso("\nEmpresa ${e.nome} cadastrada com sucesso!")
        ConsoleUtil.pausar(scanner)
    }

    private void menuCandidatoCurteVaga() {
        ConsoleUtil.limparTela()
        ConsoleUtil.printTitulo("--- CANDIDATO CURTINDO VAGA ---")

        candidatoController.listarCandidatos()
        String email = lerStringValida("\nDigite o email do Candidato: ")
        Candidato candidato = candidatoController.listaCandidatos.find { it.email == email }

        if (candidato) {
            vagaController.listarVagas()
            Integer idVaga = lerInteiroValido("\nDigite o ID da Vaga que ele quer curtir: ")
            Vaga vaga = vagaController.buscarVagaPorId(idVaga)

            if (vaga) {
                matchController.candidatoCurteVaga(candidato, vaga)
                ConsoleUtil.printSucesso("O candidato curtiu a vaga!")
            } else {
                ConsoleUtil.printErro("Vaga não encontrada.")
            }
        } else {
            ConsoleUtil.printErro("Candidato não encontrado.")
        }
        ConsoleUtil.pausar(scanner)
    }

    private void menuEmpresaCurteCandidato() {
        ConsoleUtil.limparTela()
        ConsoleUtil.printTitulo("--- EMPRESA CURTINDO CANDIDATO ---")

        empresaController.listarEmpresas()
        String cnpj = lerStringValida("\nDigite o CNPJ da Empresa: ")
        Empresa empresa = empresaController.listaEmpresas.find { it.cnpj == cnpj }

        if (empresa) {
            candidatoController.listarCandidatos()
            String email = lerStringValida("\nDigite o email do Candidato (perfil anônimo avaliado): ")
            Candidato candidato = candidatoController.listaCandidatos.find { it.email == email }

            if (candidato) {
                matchController.empresaCurteCandidato(empresa, candidato)
                ConsoleUtil.printSucesso("A empresa curtiu o candidato!")
            } else {
                ConsoleUtil.printErro("Candidato não encontrado.")
            }
        } else {
            ConsoleUtil.printErro("Empresa não encontrada.")
        }
        ConsoleUtil.pausar(scanner)
    }


    private String lerStringValida(String mensagem) {
        while (true) {
            print mensagem
            String input = scanner.nextLine().trim()
            if (!input.isEmpty()) {
                return input
            }
            ConsoleUtil.printErro("Erro: Este campo não pode ficar vazio. Tente novamente.")
        }
    }

    private Integer lerInteiroValido(String mensagem) {
        while (true) {
            try {
                print mensagem
                String input = scanner.nextLine().trim()
                return input.toInteger()
            } catch (NumberFormatException e) {
                ConsoleUtil.printErro("Erro: Entrada inválida. Por favor, digite apenas números inteiros.")
            }
        }
    }
}