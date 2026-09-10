package aczg.grebechi.model

class Candidato extends Pessoa {
    String cpf
    Integer idade
    List<String> competencias = []

    @Override
    String toString() {
        return "Candidato: ${nome} | E-mail: ${email} | Idade: ${idade} | CPF: ${cpf} | Estado: ${estado} | Skills: ${competencias.join(', ')}"
    }
}
