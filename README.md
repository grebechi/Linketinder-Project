# Linketinder

MVP de uma aplicação inspirada no LinkedIn e Tinder, focada em conectar empresas a candidatos de forma direta baseada em competências. Desenvolvido para o programa Acelera ZG.

## Autor
- Luiz Gabriel Rebechi

## Tecnologias Utilizadas
- Groovy
- Orientação a Objetos (POO)
- Arquitetura MVC (Model-View-Controller)

## Desafio das 'Curtidas'
- **Sistema de Match (Curtidas):** Foi implementado o primeiro desafio do Linketinder. Agora candidatos podem curtir vagas, e empresas podem curtir candidatos pelo seu perfil de competências.
- A lógica verifica as interações de forma independente. Quando as duas pontas demonstram interesse, o sistema emite um alerta de "Match", permitindo a quebra do anonimato.
- Novas entidades adicionadas: `Vaga`, `Curtida`, `MatchController` e `VagaController`.

## Como executar o projeto
1. Certifique-se de ter o Java e Groovy instalados na sua máquina ou utilize o IntelliJ IDEA com suporte a Groovy.
2. Clone este repositório: `git clone https://github.com/grebechi/Linketinder-Project.git`
3. Abra o projeto no IntelliJ IDEA.
4. Navegue até a pasta `src` e execute o arquivo `Main.groovy`.
5. Interaja com o menu diretamente pelo terminal integrado da IDE.