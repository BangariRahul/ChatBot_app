# Chat Bot

Chat Bot is a Spring Boot project that integrates with the ChatGPT API to provide conversational capabilities. This project aims to demonstrate how to create a chatbot using Spring Boot and leverage the power of ChatGPT for generating responses.



## Getting Started

### 1. Clone the Repository

```git clone https://github.com/BangariRahul/ChatBot_app.git```

### 2. Configure ChatGPT API
Add you Api key in src/main/resources/application.properties
```chatgpt.api.key=YOUR_API_KEY_HERE```

## APi Endpoint

POST REQUEST : localhost:8080/api/v1/chat
#### body
{
"prompt" : "type your prompt here"
}
