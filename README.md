# 🚗 Estacionamento - POOII

Projeto acadêmico em **Java** com integração ao **Microsoft Access** para gestão de carros em um estacionamento.

## 📌 Tecnologias
- Java
- JDBC
- Microsoft Access
- UCanAccess Driver
- Swing (interface gráfica)

## 📂 Estrutura
- `src/` → código fonte em Java
- `lib/` → bibliotecas externas (UCanAccess)
- `database/` → banco de dados Access `.accdb`

## ▶️ Como executar
1. Baixe ou clone este repositório.
2. Instale o [UCanAccess](http://ucanaccess.sourceforge.net/site.html) e adicione o `.jar` ao classpath.
3. Compile os arquivos Java:
   ```bash
   javac -cp ".;lib/*" src/*.java

## 🚀 Execute a aplicação
```bash
java -cp ".;lib/*;src" EstacionamentoGUI

# ✨ Funcionalidades

- Cadastrar carros
- Listar carros
- Salvar dados no banco Access
- Interface gráfica simples

# 👩‍💻 Autora

Amanda Albuquerque
