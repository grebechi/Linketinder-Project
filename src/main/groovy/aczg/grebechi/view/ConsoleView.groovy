package aczg.grebechi.view

import aczg.grebechi.controller.CandidatoController
import aczg.grebechi.controller.EmpresaController
import aczg.grebechi.model.Candidato
import aczg.grebechi.model.Empresa
import aczg.grebechi.util.ConsoleUtil

class ConsoleView {
    CandidatoController candidatoController = new CandidatoController()
    EmpresaController empresaController = new EmpresaController()
    Scanner scanner = new Scanner(System.in)

    void iniciar() {
        boolean rodando = true

        while (rodando) {
            ConsoleUtil.limparTela()
            ConsoleUtil.printTitulo("===================================")
            ConsoleUtil.printTitulo("   BEM-VINDO AO LINKETINDER MVP")
            ConsoleUtil.printTitulo("===================================")
            println "1. Listar Candidatos"
            println "2. Listar Empresas"
            println "3. Cadastrar Novo Candidato"
            println "4. Cadastrar Nova Empresa"
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