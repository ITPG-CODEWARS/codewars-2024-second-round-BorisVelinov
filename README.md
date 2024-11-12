```markdown
URL Shortener Project
Описание
Този проект представлява URL съкратител, който позволява на потребителите да въвеждат дълги URL адреси и да ги преобразуват в кратки, персонализирани такива. Проектът използва Java Spring Boot за backend частта и MySQL като база данни, в която се съхраняват URL адресите и статистиките.

Функционалности
Генериране на кратки URL адреси: Потребителят може да въведе дълъг URL адрес и да получи кратък, който сочи към същия ресурс.
Персонализиране на краткия URL: Потребителят има възможност да избере текст за краткия URL адрес, ако този текст не е зает.
Избор на дължина на генерирания URL адрес: Поддържа дължина от 5 до 10 символа.
Проследяване на кликванията: Приложението съхранява и показва броя на кликванията върху всеки кратък URL.
Генериране на QR код: Приложението може да генерира QR код, който води към краткия URL, който потребителят може да свали.
Задаване на срок на валидност (по избор): Потребителите могат да задават срок, след който краткият URL адрес става невалиден.
Потребителски панел: Потребителите могат да се регистрират, да преглеждат създадените от тях кратки URL адреси, да редактират и изтриват връзки.
Технологии
Back-End: Java Spring Boot
Database: MySQL
Front-End: HTML, CSS, JavaScript (или предпочитана front-end библиотека/фреймуърк)
API: RESTful API, предоставящ CRUD функционалности за URL адреси
Изисквания за стартиране
Java 11 или по-нова версия
Maven (за изграждане на проекта)
MySQL (създайте база данни с име url_shortener_db)
Git (за управление на версиите и хранилището)
Инструкции за инсталация и стартиране
Клониране на хранилището:

bash
Копиране на код
git clone <URL на вашето хранилище>
cd url-shortener-project
Настройка на базата данни:

В MySQL създайте нова база данни и потребител:

sql
Копиране на код
CREATE DATABASE url_shortener_db;
CREATE USER 'username'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON url_shortener_db.* TO 'username'@'localhost';
FLUSH PRIVILEGES;
Конфигурация:

Отворете src/main/resources/application.properties и добавете вашите данни за връзка с базата данни:

properties
Копиране на код
spring.datasource.url=jdbc:mysql://localhost:3306/url_shortener_db
spring.datasource.username=username
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Стартиране на приложението:

Използвайте Maven за изграждане и стартиране:

bash
Копиране на код
mvn clean install
mvn spring-boot:run
Достъп до приложението:

Приложението е достъпно на: http://localhost:8080

API Ендпойнти
POST /api/urls – Създава нов кратък URL адрес
GET /api/urls/{shortUrl} – Пренасочва към оригиналния URL адрес и увеличава броя на кликванията
GET /api/urls/{shortUrl}/stats – Връща статистика за конкретен кратък URL адрес
DELETE /api/urls/{shortUrl} – Изтрива кратък URL адрес
PUT /api/urls/{shortUrl} – Актуализира съществуващ кратък URL адрес
Структура на проекта
css
Копиране на код
url-shortener-project/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/example/urlshortener/
│   │   │   │       ├── controller/
│   │   │   │       ├── model/
│   │   │   │       ├── repository/
│   │   │   │       ├── service/
│   │   │   │       └── UrlShortenerApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
├── README.md
└── pom.xml
