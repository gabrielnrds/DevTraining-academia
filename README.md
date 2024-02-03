DevTraining
Sistema de gerenciamento de academia

Descrição do projeto:

Implementação de uma aplicação de gerenciamento de Academia para uso administrativo, de instrutores/professores e de alunos. Visando o controle de pessoal, com horarios, salarios e etc... alem do uso para cadastramento de tipos de treino para alunos por professores e a impressão da ficha de treino por parte do aluno. Tambem tentaremos implementar com base no Teachable Machine mostrado em sala um controle de acesso a academia via reconhecimento facial para ser utilizado na recepção da academia.

Responsaveis pelo projeto:

Paulo Miguel, Vinicius Lima, Wendell Vinicius, Gabriel Nascimento.

Requisitos do sistema:

REQ1 - Controle de acesso ao sistema por meio de login e senha, existindo dois níveis de permissão: administrador e cliente.

REQ2 - Será possível a criação de login de usuário, como também sua modificação posteriormente. O sistema será limitado a um único usuário com permissão de administrador e cada cliente terá direito a um cadastro. A ideia é que professores e os funcionários tenham acesso ao sistema por um único login com privilégios de admin.

REQ3 - O admin poderá registrar avaliações físicas dos clientes cadastrados no sistema, armazenando essas informações em repositório.

REQ4 - O sistema deve permitir o gerenciamento (CRUD) de clientes, professores, treinos, usuários e avaliações.

REQ5 - O admin vai poder criar e manipular as fichas de treino dos clientes.

REQ6 - O sistema deve ter a função de listar todos os cadastros para visualização e acesso aos detalhes de cada um.

REQ7 - No registro de uma avaliação o sistema deve calcular IMC do cliente com base na altura e peso, classificando ainda o resultado.

REQ8 - O sistema deve verificar, durante o acesso do cliente à academia, o status da matrícula do cliente, tendo dois casos possíveis: “ativo” ou “inativo”. Dependendo do resultado, permitir ou não a liberação da catraca.

REQ9 - Acesso dos clientes a academia por meio de reconhecimento facial (utilizando o Teachable Machine).

REQ10 - Relatório da quantidade de matrículas, trancamentos e cancelamentos durante um período.

REQ11 - Relatório de horário de pico da academia durante seu horário de funcionamento.

REQ12 - O sistema contará com a ferramenta de feedback, no qual serão registradas as experiências e sugestões dos clientes com relação a academia e as funcionalidades da aplicação.

Obs.: Mais funcionalidades futuramente.
