# API de Autenticação e Autorização JWT com Spring Boot

## 🚀 Visão Geral

Esta API foi construída com **Spring Boot 3.x** para fornecer autenticação e autorização baseada em **JWT (JSON Web Tokens)**, gerando e validando tokens internamente. É ideal para arquiteturas que demandam segurança robusta, stateless e escalável, protegendo recursos e endpoints de forma eficiente.

A aplicação implementa as melhores práticas de:

- Segurança  
- Testabilidade  
- Documentação automática (Swagger / OpenAPI)  
- Monitoramento com Prometheus e Grafana  

---

## 📦 Tecnologias e Dependências

- Spring Boot Starter Web (REST API)  
- Spring Boot Starter Security (Autenticação e autorização)  
- Spring Boot Starter OAuth2 Resource Server (Validação JWT)  
- Spring Boot Starter Data JPA (Persistência)  
- Banco de dados H2 em memória (desenvolvimento e testes)  
- Lombok (redução de boilerplate)  
- Springdoc OpenAPI (documentação Swagger)  
- Spring Boot DevTools (hot reload)  
- JUnit 5 e Mockito (testes automatizados)  
- Auth0 Java JWT (geração e validação de tokens)  
- Prometheus (monitoramento)  
- Grafana (visualização dos dados de métricas)  
- Docker (empacotamento e deploy)  
- Render (hospedagem na nuvem)  

---

## 🔑 Funcionalidades Principais

### Autenticação

- Login via endpoint `/auth/login`
- Register via endpoint `/auth/register`
- Recebe username e password  
- Retorna token JWT assinado se credenciais estiverem corretas  

### Validação de Token

- Endpoint `/auth/validate` para validar tokens JWT existentes  
- Retorna sucesso ou erro conforme validade e expiração  

### Proteção de Endpoints

- Configuração Spring Security para proteger endpoints  
- Stateless: sem sessões, apenas validação via JWT  
- Suporte a roles para autorização (ex: ADMIN, USER)  

---

## Estrutura do Projeto

- **Model**: Entidade `User` com username, password codificada e role  
- **Repository**: `UserRepository` para acesso a dados  
- **Service**: `JwtService` (geração/validação do token), `AuthService` (lógica de autenticação)  
- **Controller**: `AuthController` para login e validação, `TestProtectedController` para testes de endpoints protegidos  
- **Config**: `SecurityConfig` para regras do Spring Security, configuração JWT e criação inicial de usuários  

## 📚 Documentação da API

A documentação interativa está disponível em:
[https://avaliacao02-arquitetura-web.onrender.com/swagger-ui/index.html](https://avaliacao02-arquitetura-web.onrender.com/swagger-ui/index.html)

Lá você pode testar os endpoints e ver descrições detalhadas de cada um.

---

## 🧪 Testes Automatizados

Testes integrados foram implementados com JUnit 5 e MockMvc para garantir:

- Autenticação bem-sucedida e falha  
- Validação correta de tokens  
- Proteção de endpoints sem token ou com token inválido  
- Restrição de acesso baseado em roles  

---

## 📈 Testes de Carga (JMeter)

Inclui roteiro básico para simular múltiplos usuários realizando login para avaliar performance.

---

## 🔧 Como Rodar

1. Clone o repositório  
2. Configure a variável de ambiente para `jwt.secret` (em produção)  
3. Execute via Maven ou IDE:  

```bash
./mvnw spring-boot:run
```

## Acesse

- API em: [https://avaliacao02-arquitetura-web.onrender.com](https://avaliacao02-arquitetura-web.onrender.com)
- H2 Console em: [https://avaliacao02-arquitetura-web.onrender.com/h2-console/](https://avaliacao02-arquitetura-web.onrender.com/h2-console/)
- Swagger UI em: [https://avaliacao02-arquitetura-web.onrender.com/swagger-ui/index.html](https://avaliacao02-arquitetura-web.onrender.com/swagger-ui/index.html)
---

## Usuários padrões criados no startup

- **admin** / senha: `123456` (role ADMIN)  
- **user** / senha: `password` (role USER)  

---

## Contato

Desenvolvido por Samuel Vidal

---

## Licença

Este projeto está licenciado sob a licença Apache 2.0 - veja o arquivo [LICENSE](LICENSE) para detalhes.
