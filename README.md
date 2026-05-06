# Final Project – The Clean Code & Automation Cycle

- **Marlon Daly Carballo**  
- **José Soto Mantegáza**  
- **Domingo Rodríguez Villalba**

The project includes both the **legacy (smelly)** version and the **refactored (clean)** version of the code.
We did it this way soo that it would be easier to see and edit changes and be able to study further the old and new
better way of writting the code. 

---

## 📁 Repository Structure

📁 src  
 ├── 📂 main/java  
 │     ├── ❌ MalTaskController.java  
 │     └── ✅ TaskController.java  
 └── 📂 test/java  
       ├── ❌ MalTaskControllerTest.java  
       └── ✅ TaskControllerTest.java  


Additional files:
- `pom.xml` – Maven configuration (Selenium, JUnit, WebDriverManager)
- `README.md` – Project documentation
- `.idea/` – IntelliJ IDEA project metadata because this activity was made in this app

---

## 🧪 Selenium Test Suite

The project includes a functional Selenium WebDriver test suite that:

- Launches Chrome using WebDriverManager  
- Navigates to a stable test website  
- Creates Task and User objects  
- Calls the refactored controller logic  
- Ensures no exceptions occur during execution  

The clean test (`TaskControllerTest.java`) follows best practices:
- Clear Arrange–Act–Assert structure  
- No hardcoded long parameter lists  
- Uses object instances instead of primitive parameter explosions  
- Proper setup and teardown with JUnit 5  

---

## 🧹 Code Smells Introduced (Legacy Version)

The file **MalTaskController.java** contains **10 different Code Smells**, one from each required category:

### **Bloaters**
- **Long Method**  
- **Large Class**

### **Object-Orientation Abusers**
- **Switch Statement** (should be replaced with polymorphism)  
- **Temporary Field**

### **Change Preventers**
- **Divergent Change**  
- **Shotgun Surgery**

### **Dispensables**
- **Duplicate Code**  
- **Dead Code**

### **Couplers**
- **Feature Envy**  
- **Inappropriate Intimacy**

Each smell is clearly marked with comments inside the legacy file.

---

## ✨ Refactoring Summary (Clean Version)

The file **TaskController.java** contains the fully refactored version, applying:

### ✔ Extract Method  
Splitting long methods into smaller, meaningful units.

### ✔ Extract Class  
Separating responsibilities into `Task`, `User`, and controller logic.

### ✔ Replace Conditional with Polymorphism  
Discount logic moved into `Task.applyDiscount()`.

### ✔ Encapsulate Field  
User data is now private and updated through methods.

### ✔ Remove Dead Code  
Unused variables and legacy logic removed.

### ✔ Remove Duplicate Code  
Centralized tax calculation and validation logic.

### ✔ Single Responsibility Principle  
Each class now has one clear purpose.

### ✔ Improved Testability  
Refactored code is easier to test and maintain.

---

## 🛠 Technical Stack

- **IDE:** IntelliJ IDEA (mandatory refactoring shortcuts used)
- **Language:** Java 17+
- **Build Tool:** Maven
- **Testing:** Selenium WebDriver + JUnit 5
- **Browser Driver:** WebDriverManager (automatic driver setup)
- **Version Control:** Git & GitHub

---

## 📊 Presentation (Slides)

The slide deck includes:

- Visual comparison of legacy vs clean code  
- Explanation of each Code Smell  
- Refactoring patterns applied  
- Screenshots of IntelliJ refactoring tools  
- Selenium test execution results  
