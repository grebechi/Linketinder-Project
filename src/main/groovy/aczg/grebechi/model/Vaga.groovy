package aczg.grebechi.model

class Vaga {
    Integer id
    String titulo
    String descricao
    Empresa empresa
    List<String> competenciasObrigatorias = []

    @Override
    String toString() {
        return "[Vaga #${id}] ${titulo} na ${empresa.nome} | Skills: ${competenciasObrigatorias.join(', ')}"
    }
}