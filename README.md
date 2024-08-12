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
