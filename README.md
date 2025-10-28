Sistema de Integração de APIs de Mídia Social
Este projeto é uma solução para o exercício prático de implementação de um sistema unificado de gerenciamento de redes sociais, utilizando os padrões de design Adapter, Strategy e Factory Method.

Objetivo
O objetivo é criar um sistema de agendamento e publicação de conteúdo para uma agência de marketing. O sistema deve fornecer uma interface unificada (GerenciadorMidiaSocial) para interagir com múltiplas APIs de redes sociais (simuladas) que são heterogêneas, ou seja, possuem métodos, modelos de dados e autenticação diferentes.

Padrões de Design Utilizados
A arquitetura combina três padrões de design principais para alcançar uma solução flexível, desacoplada e de fácil manutenção.

1. Padrão Adapter
O padrão Adapter é o núcleo da solução. Ele é usado para "traduzir" a interface de uma classe (a API externa, ou Adaptee) para uma interface compatível que o cliente espera (a interface Target).

Target (Interface Alvo): ISocialMediaAdapter. Define os métodos unificados, como postar(Conteudo conteudo).

Adaptees (APIs Externas): TwitterAPI, InstagramAPI, LinkedInAPI. Cada uma tem seus próprios métodos (ex: tweet(), postarFoto(), shareUpdate()).

Adapters (Adaptadores): TwitterAdapter, InstagramAdapter, LinkedInAdapter. Cada um implementa ISocialMediaAdapter e, internamente, chama a API específica, traduzindo as requisições e as respostas (ex: PublicacaoResposta).

2. Padrão Strategy
O padrão Strategy é usado para definir uma família de algoritmos (neste caso, "algoritmos de publicação") e encapsulá-los, tornando-os intercambiáveis.

Context (Contexto): GerenciadorMidiaSocial.

Strategy (Interface da Estratégia): ISocialMediaAdapter.

Concrete Strategies (Estratégias Concretas): TwitterAdapter, InstagramAdapter, etc.

O GerenciadorMidiaSocial não sabe qual plataforma está usando; ele apenas executa a estratégia (o adapter) que lhe é fornecida.

3. Padrão Factory Method
O padrão Factory Method (ou, neste caso, uma Simple Factory) é usado para encapsular a lógica de criação dos Adapters.

O GerenciadorMidiaSocial não instancia os adapters diretamente (ex: new TwitterAdapter(...)).

Ele pede à SocialMediaFactory para criar o adapter necessário com base em uma Plataforma e Configuracao.

Isso centraliza a lógica de criação e injeção de dependência (como passar a API key correta para a TwitterAPI), tornando o sistema mais limpo e fácil de configurar.