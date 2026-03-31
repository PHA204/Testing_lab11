# Selenium Framework - Lab 11

Framework kiểm thử tự động với Selenium + TestNG + Maven theo mô hình Page Object Model.

## Yêu cầu
- Java 17+
- Maven 3.8+
- Chrome hoặc Firefox

## Chạy local

```bash
# Chạy smoke test với Chrome
mvn clean test -Dbrowser=chrome -DsuiteXmlFile=testng-smoke.xml

# Chạy với Firefox
mvn clean test -Dbrowser=firefox -DsuiteXmlFile=testng-smoke.xml
Biến môi trường cần thiết
Xem file .env.example

---
