# 🚀 Selenium Automation Project

This project contains **UI Automation Test Scripts** using **Selenium WebDriver** and **TestNG** in Java.  
The test cases interact with the practice website:  
👉 [https://codenboxautomationlab.com/practice/](https://codenboxautomationlab.com/practice/)

---

## 🛠️ Tools & Technologies
- **Java** (JDK 11+ recommended)
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **ChromeDriver**
- **Eclipse IDE** (or IntelliJ IDEA)

---

## 📂 Project Structure
AutomationSimiFinalPro/
├── src/test/java/
│ └── AutomationSimiFinalPro/
│ └── AppTest.java # Main test class containing all test cases
├── pom.xml # Maven configuration and dependencies
└── README.md # Project documentation


---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository
```bash
git clone https://github.com/your-username/AutomationSimiFinalPro.git
cd AutomationSimiFinalPro
2️⃣ Install dependencies

mvn clean install
3️⃣ Configure ChromeDriver
Download the ChromeDriver version matching your Chrome browser:
https://chromedriver.chromium.org/downloads

Add it to your system PATH or configure in the code.

4️⃣ Run the tests
From Eclipse/IntelliJ:
Right-click on AppTest.java → Run As → TestNG Test

From terminal (Maven):


mvn test
🧪 Test Cases Implemented
The AppTest.java class includes multiple UI automation scenarios:

AutoComplete Test → Fills an autocomplete input with random country code.

Dropdown Select → Selects an option from a dropdown list.

Checkbox Selection → Selects a random checkbox.

Window Handling → Switches between multiple browser windows.

Tab Handling → Opens and switches between tabs.

Alert Handling → Works with JavaScript alerts (accept/dismiss).

Table Data Extraction → Reads and prints data from a web table.

Hide & Show → Tests the hide/show textbox functionality.

Enabled/Disabled Input → Verifies enabling/disabling an input field.

Mouse Hover → Performs hover action and clicks sub-menu options.

Calendar Handling → Extracts data from a booking calendar.

iFrame Handling → Switches into an iframe and performs actions.

File Download → Clicks on a link to download APK files.

📌 Notes
Thread.sleep() is used in some tests only for demo/visualization.
✅ Best practice: replace with WebDriverWait for synchronization.

You can enable/disable tests using the enabled attribute in the @Test annotation.

Execution order is controlled by the priority attribute.

👩‍💻 Author
Dima Mahmoud Adnan Ejbarah 