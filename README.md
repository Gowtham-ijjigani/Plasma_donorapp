# Plasma Donor Application (Single File - Full Stack Java)

## 📌 Project Overview

The **Plasma Donor Application** is a simple full-stack Java web application designed to connect plasma donors with recipients in need. Built entirely within a single Java servlet file, this project demonstrates a lightweight and effective way to match donors based on blood group compatibility and eligibility.

---

## 🧩 Features

- 🔍 **Search by Blood Group**: Recipients can find potential donors based on required blood group.
- ✅ **Eligibility Filter**: Only eligible donors are shown in results.
- 🧾 **Donor Data Simulation**: Uses hardcoded donor data to simulate a database.
- 🖥️ **Integrated Frontend & Backend**: HTML rendered dynamically within the servlet using `PrintWriter`.
- 💡 **Minimal Setup**: No external dependencies or databases needed.

---

## 🛠️ Technologies Used

- Java (Servlet API)
- JSP-like HTML generation
- HTTP (GET/POST methods)
- Web Container (e.g., Apache Tomcat)

---

## 🧪 How It Works

1. Recipient visits `/plasma` and enters a required blood group.
2. Application processes the input and filters eligible donors from the simulated database.
3. Matching donor names and contact details are displayed dynamically.
4. User can go back and search again.

---

## 🚀 Getting Started

### 📦 Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Tomcat or any Servlet-compatible web server
- IDE (like IntelliJ IDEA, Eclipse, or VSCode with Java support)

### 🧰 Setup Instructions

1. Clone or download the project.
2. Place the Java servlet file in the `src` folder of a dynamic web project.
3. Add servlet mappings in `web.xml` or use annotations (`@WebServlet("/plasma")`).
4. Deploy the project to a servlet container like Tomcat.
5. Access the application at `http://localhost:8080/<your-project-name>/plasma`.

---

## 📂 Project Structure

