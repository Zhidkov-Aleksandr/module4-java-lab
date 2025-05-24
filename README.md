![image](https://github.com/user-attachments/assets/80fa265d-ae75-4628-9117-c54911be95c6)




<h1 align="center">
  🐣  **User-API** — мини-REST-сервис на Spring Boot
</h1>
<p align="center">
  <a href="https://maven.apache.org/">
    <img src="https://img.shields.io/badge/Maven-3.9%2B-brightgreen?logo=apachemaven" alt="Maven" />
  </a>
  <a href="https://adoptium.net/">
    <img src="https://img.shields.io/badge/Java-21-blue?logo=openjdk" alt="Java 21" />
  </a>
  <a href="https://spring.io/">
    <img src="https://img.shields.io/badge/Spring Boot-3.3.x-brightgreen?logo=spring" alt="Spring Boot" />
  </a>
  <a href="LICENSE">
    <img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="MIT License" />
  </a>
</p>

> **Учебный REST-сервис:**  
> выводит список пользователей и даёт добавлять новых, хранит данные в in-memory базе **H2**.

---

## ✨ Возможности

- Базовые операции **GET** и **POST** (остальные CRUD легко добавить)
- Слои **Controller → Service → Repository**
- **Spring Data JPA** + **H2** ⇒ не нужна внешняя СУБД
- Таблица `user` создаётся автоматически и заполняется 5 демо-записями
- Чистый Java 21, один модуль Maven, без XML-конфигов
- Готов к контейнеризации (заготовка `Dockerfile`)

---

## 🚀 Быстрый старт

```bash
# клонируем, собираем и запускаем
git clone https://github.com/<you>/user-api.git
cd user-api
./mvnw spring-boot:run

| Метод    | URL                  | Описание             | Пример `curl`                                                                                                                                                          |
| -------- | -------------------- | -------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **GET**  | `/user-api/v1/users` | Список пользователей | `curl http://localhost:8080/user-api/v1/users`                                                                                                                         |
| **POST** | `/user-api/v1/users` | Создать пользователя | `curl -X POST -H "Content-Type: application/json" \`<br>`-d '{"firstName":"John","lastName":"Doe","role":"DEVELOPER"}' \`<br>`http://localhost:8080/user-api/v1/users` |
```

<details> <summary>📦 Пример ответа (GET)</summary>
```json
Копировать
Редактировать
  {
    "id": 1,
    "firstName": "Ada",
    "lastName": "Lovelace",
    "role": "DEVELOPER"
  },
  ...
</details>
```

🗄️ Стек технологий
```
| Слой    | Технологии                         |
| ------- | ---------------------------------- |
| Runtime | **Java 21**, **Spring Boot 3.3**   |
| Web     | Spring Web (MVC, Jackson)          |
| Data    | Spring Data JPA, Hibernate, **H2** |
| Сборка  | Maven / Wrapper                    |
| Тесты   | Spring Boot Test (JUnit 5)         |
```


🛠️ Структура проекта
```
css
Копировать
Редактировать
src
 └─ main
    ├─ java/com/example/userapi
    │   ├─ Application.java          ← старт + демо-данные
    │   ├─ controller/UserController ← REST
    │   ├─ service/UserService       ← логика
    │   ├─ repository/UserRepository ← JPA
    │   └─ model
    │        ├─ User.java
    │        └─ Role.java
    └─ resources
        └─ application.properties    ← конфиг H2
```

⚙️ Ключевые свойства

```
| Свойство                        | Значение по умолчанию | Назначение                        |
| ------------------------------- | --------------------- | --------------------------------- |
| `spring.datasource.url`         | `jdbc:h2:mem:userdb`  | In-memory DB                      |
| `spring.jpa.hibernate.ddl-auto` | `update`              | Авто-создание схемы               |
| `spring.h2.console.enabled`     | `true`                | Веб-консоль H2 на **/h2-console** |
```
