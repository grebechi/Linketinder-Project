package aczg.grebechi.model

class Curtida {
    Candidato candidato
    Empresa empresa
    Vaga vaga

    boolean candidatoCurtiu = false
    boolean empresaCurtiu = false

    // Um match só acontece se AMBOS curtiram
    boolean isMatch() {
        return candidatoCurtiu && empresaCurtiu
    }
}