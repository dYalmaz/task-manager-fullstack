# Task Manager: Java/C# Integration Project

This project is a full-stack task management system built to explore how a Java-based backend and a C# frontend can work together. I wanted to move beyond a simple "Hello World" and tackle real-world challenges like persistent sorting, state management, and real-time filtering across different language ecosystems.

## The Stack

* **Backend:** Spring Boot with an H2 database. I used Spring Data JPA to handle persistence and created a REST API to serve the frontend.
* **Frontend:** Blazor WebAssembly. This allowed me to build a rich, interactive UI using C# instead of relying heavily on JavaScript.
* **Communication:** The two sides communicate over HTTP, with the Blazor app acting as the client for the Spring Boot service.

## Notable Challenges and Solutions

### Persistent Task Sorting
One of the more complex parts of this project was implementing manual sorting. I didn't want the tasks to just reset to "ID order" every time the page refreshed.

* **The Solution:** I added a sortOrder field to the database. When a user clicks the up or down arrows in the UI, the frontend calculates the new order and sends multiple update requests to the Java API. The backend then uses a custom repository query to return the tasks in that exact sequence.



### Real-time Filtering
I implemented a search bar that filters tasks as you type. Instead of hitting the database for every keystroke, I used LINQ on the client side to filter the in-memory list. This keeps the app feeling fast while reducing unnecessary server load.

### Visual Organization
To make the app usable, I separated active work from completed tasks. Completed items are automatically moved to a "Completed" section at the bottom, grayed out, and given a strike-through style. I also added a vertical color-coded priority system (High, Medium, Low) to help with scannability.

## How to Set It Up

### 1. Run the Backend
You'll need a JDK installed. Navigate to the backend directory and run:
`./mvnw spring-boot:run`
The API will be available at http://localhost:8080.

### 2. Run the Frontend
Make sure you have the .NET SDK. Navigate to the frontend folder and run:
`dotnet watch run`
The UI will open in your default browser.

## What I Learned
Building this project taught me a lot about handling CORS issues, managing asynchronous race conditions (especially when swapping task positions), and the importance of keeping the UI state in sync with the database. It was a great exercise in building a "Golden Bridge" between two different enterprise-grade languages.