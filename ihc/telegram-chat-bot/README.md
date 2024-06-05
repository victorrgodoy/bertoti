# Chatbot com LLama e Banco de Dados SQLite

Este projeto configura um chatbot utilizando o modelo de linguagem LLama e um banco de dados SQLite para gerenciar livros e autores. O chatbot é implementado utilizando a biblioteca `telebot` para interagir com usuários via Telegram.

O chat do Telegram interage por meio de uma inteligência artificial (IA) que lê a mensagem do usuário e busca a melhor correspondência entre as funções predefinidas dentro do código. Este sistema pode ser ajustado para diferentes fins, dependendo das necessidades do projeto.


## Link para o Google Colab

Você pode acessar o projeto completo no Google Colab através deste [link](https://colab.research.google.com/drive/1UEKwRdVjj-QOFQ9mst3jLB5ATZeKV_vR#scrollTo=9sWGWwgcSaXq).

## Configurando o Telegram

Para configurar o Telegram no seu celular:

1. Baixe e instale o aplicativo do Telegram a partir da loja de aplicativos do seu dispositivo.
2. Crie uma conta ou faça login com sua conta existente.
3. Procure por "@BotFather" e inicie uma conversa.
4. Use o comando `/newbot` para criar um novo bot e siga as instruções fornecidas pelo BotFather.
5. Após a criação do bot, você receberá um token de API. **Guarde este token, pois ele será necessário para configurar o bot no código.**

## Configurando o Token do Bot

No código do Google Colab, há uma parte onde você deve inserir o token do seu bot do Telegram. Procure pela linha que contém:

```python
API_TOKEN = 'insira-o-token-aqui'
```

Substitua `insira-o-token-aqui` pelo token que você recebeu do BotFather.

## Executando o Código

Para executar o código no Google Colab:

1. Abra o notebook no Google Colab usando o link fornecido.
2. Aperte `Ctrl+F9` para executar todas as células do notebook.
3. Aguarde até que todas as células sejam executadas e o código tenha terminado de rodar. Note que a última célula, que inicia o bot, permanecerá em execução, o que significa que o bot está ativo e pronto para receber mensagens.

O bot estará pronto para uso. Você pode começar a interagir com ele através do bot do Telegram que você criou.

# Funções do Bot

Até o momento, o bot implementa as seguintes funcionalidades:

1. **Saudar Usuário:** Cumprimenta o usuário e pergunta como pode ajudar.

2. **Buscar Livros:** Permite buscar por livros no banco de dados pelo título.

3. **Adicionar ao Carrinho:** Adiciona um livro ao carrinho de compras.

4. **Remover do Carrinho:** Remove um livro do carrinho de compras.

5. **Visualizar Carrinho:** Mostra os livros presentes no carrinho de compras e o total a ser pago.

6. **Finalizar Compra:** Finaliza a compra e limpa o carrinho.

7. **Obter Autor pelo Título do Livro:** Retorna o autor de um livro especificado pelo título.

Cada função desempenha um papel específico no bot, facilitando a interação do usuário com o sistema de gerenciamento de livros e autores.

---

Este projeto demonstra como integrar um chatbot inteligente com um banco de dados SQLite, fornecendo funcionalidades úteis para gerenciamento de livros e autores. Sinta-se à vontade para modificar e expandir o projeto conforme suas necessidades.
