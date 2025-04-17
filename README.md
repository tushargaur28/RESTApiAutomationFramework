# REST API Automation Framework

A production-ready REST API automation framework built using **Java**, **Rest Assured**, **TestNG**, and **Maven**. Designed for scalable API testing, detailed reporting, and CI/CD integration.

---

## 🔧 Tech Stack

- Java 21
- Rest Assured
- TestNG
- Maven
- Extent Reports
- Jenkins-ready

---

## 📁 Project Structure

src/
└── test/
├── base/             → Base setup and request specifications
├── tests/            → Organized test classes per API
├── utils/            → Common utilities (data loader, validator, etc.)
├── payload/          → JSON payloads for POST/PUT
└── resources/
└── config.properties  → Centralized test configuration

---

## ✅ Key Features

- Modular and scalable architecture
- Centralized configuration
- Reusable request and response utilities
- Retry mechanism for flaky APIs
- HTML reporting via Extent Reports
- Ready for Jenkins/GitHub Actions
- Test filtering with XML suites

---

## 🚀 Getting Started

### 1. Clone the Repo
```bash
git clone https://github.com/tushargaur28/RESTApiAutomationFramework.git
cd RESTApiAutomationFramework

2. Run All Tests

mvn clean test

3. Run Specific Suite

mvn clean test -DsuiteXmlFile=testng-smoke.xml



⸻

🧪 Sample Test Coverage

Endpoint	Method	Status
/users	GET	✅
/users/{id}	GET	✅
/users	POST	✅
/users/{id}	PUT	✅
/users/{id}	DELETE	✅



⸻

📊 Reports & Logs
	•	HTML Report → test-output/ExtentReports/index.html
	•	Logs → logs/application.log

⸻

🔄 CI/CD Integration

To integrate with Jenkins or any pipeline:

mvn clean test

Archive /test-output and /logs post-build.

⸻

👤 Author

Tushar Gaur
📧 gaur.tushar281@gmail.com
🔗 LinkedIn Profile

⸻

📄 License

Open for learning, demo, and extension. Feel free to fork or build upon it with credits.

---
