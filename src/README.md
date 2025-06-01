# 📱 Console-based Social Media App Simulation

A simple Java console application that simulates core features of a social media platform. Built to demonstrate object-oriented programming (OOP) principles like **encapsulation**, **inheritance**, **abstraction**, and **polymorphism**.

---

## 🚀 Features

- 👤 User Signup & Login
- 📝 Create and View Posts
- 👥 Add Friends
- 📰 View Feed (friend posts)
- ❤️ Like and 💬 Comment on Posts
- 🧾 View all registered users

---

## 🧠 OOP Concepts Demonstrated

| Concept       | Usage Example                                          |
|---------------|--------------------------------------------------------|
| Encapsulation | Private fields and public getters/setters in models   |
| Inheritance   | `Post` → `TextPost`, `ImagePost` (if extended further) |
| Abstraction   | Use of service classes to hide internal logic         |
| Polymorphism  | Post actions like `like()`, `comment()` on different types |

---

## 🗂️ Project Structure

src/
├── model/
│ ├── User.java
│ ├── Post.java
├── service/
│ ├── UserService.java
│ └── PostService.java
├── portal/
│ └── Portal.java ← Main app runner


---
