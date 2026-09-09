package aczg.grebechi.model

class Empresa extends Pessoa {
    String cnpj
    String pais
    List<String> competenciasDesejadas = []

    @Override
    String toString() {
        return "Empresa: ${nome} | País: ${pais} | CNPJ: ${cnpj} | Skills Desejadas: ${competenciasDesejadas.join(', ')}"
    }
}
