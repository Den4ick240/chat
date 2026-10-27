# Java TCP Chat Application

> *Educational project built during university.*

## 🚀 Features

* **Client-Server Architecture:** Decoupled architecture split into a standalone backend server and a JavaFX desktop client.
* **Multi-threaded Networking:** Handles multiple simultaneous client connections using TCP socket management.
* **Custom Messaging Protocol:** Implements a polymorphic message-handling system (`IMessage`, `LoginRequest`, `ClientMessage`, `UsersOnlineRequest`, etc.) for structured client-server communication.
* **Graphical User Interface:** Built using JavaFX and FXML (`LoginWindow`, `MainWindow`) for a responsive desktop interface.
* **Configuration Management:** Externalized configuration files for IP and port binding (`config.txt` for client, `config.ini` for server).

## 🛠️ Tech Stack

* **Language:** Java
* **UI Framework:** JavaFX, FXML
* **Build Tool:** Maven
* **Networking:** Java Sockets (`TCPConnection`)

## 📁 Project Structure

* `server/`: Backend server logic, client session management, and message routing.
* `chat240/`: JavaFX desktop client application, UI controllers, and network handlers.
