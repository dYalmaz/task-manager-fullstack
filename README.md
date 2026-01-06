# Task Manager: Java/C# Integration Project

This project is a full-stack task management system built to explore how a Java-based backend and a C# frontend can work together. I wanted to move beyond a simple "Hello World" and tackle real-world challenges like persistent sorting, state management, and real-time filtering across different language ecosystems.

## Live Links
* **Live Demo:** [View Task Manager](https://dyalmaz.github.io/task-manager-fullstack/)
* **Backend API:** [Hosted on Render](https://task-manager-wy2i.onrender.com/api/tasks)

> **Note on Performance:** The backend is hosted on Render's free tier. If the site hasn't been visited recently, the API will be "asleep." On the first load, please allow **30–60 seconds** for the server to wake up.

## The Stack

* **Backend:** Spring Boot with an H2 database. I used Spring Data JPA to handle persistence and created a REST API to serve the frontend.
* **Frontend:** Blazor WebAssembly. This allowed me to build a rich, interactive UI using C# instead of relying heavily on JavaScript.
* **CI/CD:** GitHub Actions for automated deployment to GitHub Pages.

## Notable Challenges and Solutions

### The "Golden Bridge" (CORS & Security)
Connecting two different cloud platforms (GitHub Pages and Render) required navigating complex Cross-Origin Resource Sharing (CORS) policies. I implemented a custom `SecurityFilterChain` in Spring Boot to explicitly authorize the GitHub Pages origin while maintaining secure REST communication.

### Persistent Task Sorting
I implemented a manual sorting system that persists across refreshes.
* **The Solution:** I added a `sortOrder` field to the database. When a user reorders tasks in the UI, the frontend calculates the new order and syncs it via the API. The backend uses custom repository queries to ensure data returns in the user-defined sequence.

### Real-time Filtering
I implemented a search bar that filters tasks as you type. Instead of hitting the database for every keystroke, I used LINQ on the client side to filter the in-memory list. This keeps the app feeling fast while reducing unnecessary server load.

### Visual Organization
To make the app usable, I separated active work from completed tasks. Completed items are automatically moved to a "Completed" section at the bottom, grayed out, and given a strike-through style. I also added a vertical color-coded priority system (High, Medium, Low) to help with scannability.

## How to Set It Up

### Important: Production vs. Local Mode
The current code is configured to point to the **live Render API**. To run this project locally:
1. **Frontend:** In `Program.cs`, change the `BaseAddress` back to `http://localhost:8080/`.
2. **Frontend:** In `Home.razor`, update the API call paths if absolute URLs were used.
3. **Backend:** In `SecurityConfig.java`, ensure `localhost` is allowed in the CORS settings.


### 1. Run the Backend
You'll need a JDK installed. Navigate to the backend directory (task-manager-api) and run:
`./mvnw spring-boot:run`
The API will be available at http://localhost:8080.

### 2. Run the Frontend
Make sure you have the .NET SDK. Navigate to the frontend folder (task-manager-frontend) and run:
`dotnet watch run`
The UI will open in your default browser.

## What I Learned
Building this project taught me a lot about handling CORS issues, managing asynchronous race conditions (especially when swapping task positions), and the importance of keeping the UI state in sync with the database. It was a great exercise in building a "Golden Bridge" between two different enterprise-grade languages (Java and C#).