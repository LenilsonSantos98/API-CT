## API - Centro de treinamento
Para a construção da nossa API, vamos determinar as modalidades e as entidades:
 - Como modalidade teremos: Jiu Jitsu e Muay Thai.
 -  De entidades teremos: 
  Aluno,
  Instrutor,
  Aula,
  Presença.

Vamos criar então um esboço em JSON: 
```JSON
{
  "aluno": {
    "nome": "João Silva",
    "faixa": "Preta",
    "telefone": "82987872525"
  },
  "instrutor": {
    "nome": "Carlos Oliveira",
    "especialidade": "Jiu-Jitsu"
  },
  "aula": {
    "modalidade": "JIU_JITSU",
    "horario": "19:00",
    "instrutor": {
      "nome": "Carlos Oliveira",
      "especialidade": "Jiu-Jitsu"
    }
  },
  "presenca": {
    "aluno": {
      "nome": "João Silva",
      "faixa": "Preta",
      "telefone": "82987872525"
    },
    "aula": {
      "modalidade": "JIU_JITSU",
      "horario": "19:00",
      "instrutor": {
        "nome": "Carlos Oliveira",
        "especialidade": "Jiu-Jitsu"
      }
    },
    "data": "2024-08-09"
  }
}
 ```

Com base nesse JSON irei criar a diagramação de classes:
```mermaid
classDiagram
    class Aluno {
        +Long id
        +String nome
        +String faixa
        +String telefone
    }

    class Instrutor {
        +Long id
        +String nome
        +String especialidade
    }

    class Aula {
        +Long id
        +Modalidade modalidade
        +String horario
        +Instrutor instrutor
    }

    class Presenca {
        +Long id
        +Aluno aluno
        +Aula aula
        +LocalDate data
    }

    class Modalidade {
        <<enumeration>>
        JIU_JITSU
        MUAY_THAI
    }

    Aluno  -->  Presenca : comparece
    Instrutor  -->  Aula : ministra
    Aula  -->  Presenca : contém
    Aula  -->  Modalidade : utiliza
    Instrutor  -->  Aula : designado
```

<h2>Configuração das entidades</h2>
 O próximo passo foi criar o pacote 'domain' com o pacote 'model' para os modelos das entidades:
 
 ![alt text](image-1.png)

 <h2>Criação dos repositórios</h2>
  Dentro do nosso pacote 'Domain' criei o pacote 'repository' com as configurações de armazenamento para cada entidade.

![alt text](image-2.png)

Em seguida configurar o banco de dados no 'application.properties'.

![alt text](image-3.png)

Feito isso, pude rodar a aplicação e ver se as tabelas foram criadas no banco de dados h2.
 Acessando a url (http://localhost:8080/h2-console) podemos vizualizar as tabelas:

![alt text](image-4.png)

<h2>Criação dos Serviços</h2>
 Serviços para encapsular a lógica de negócio e interagir com os repositórios:
   No pacote 'Service' crio as interfaces publicas de cada entidade:

   ![alt text](image-5.png)

  Ainda dentro da pasta, cria uma sub-pasta 'impl' que terá as implementações para cada interface de serviço: 

  ![alt text](image-6.png)

   - *Para que uma sub-pasta com implementações?* :
    
    - Organização: Separar as implementações das interfaces ajuda a manter o código organizado.
    - Modularidade: Facilita a troca de implementações se necessário, como por exemplo, criar uma nova versão de um serviço sem impactar o resto do código.
    - Manutenibilidade: Torna o projeto mais fácil de manter, especialmente em projetos maiores com muitas classes de serviço.


  <h2>Controllers </h2>

Criei a camada de controle, com os controladores REST para expor os endpoints da API. 
![alt text](image-7.png)

Com o controller criado, posso usar o Swagger para ver minha API documentada sem a necessidade de um Front-End: 
![alt text](image-8.png)
Ficou possivel observar os metodos: buscar, criar, deletar e atualizar. 