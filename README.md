# MarketPlace - Contract Jobs Auction Platform

**MarketPlace** is a web application that allows users to post contract jobs to be performed. The jobs are bid on in an auction format similar to eBay, but for jobs/tasks instead of products. This repository contains both the frontend (React) and backend (Kotlin with Ktor) components of the application.

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Installation](#installation)
3. [Running the Application Locally](#running-the-application-locally)
4. [Project Structure](#project-structure)
5. [Future Features](#future-features)
## Prerequisites

To run this project locally, you will need to have the following installed on your machine:

- **Node.js** (v14.x or later)
- **npm** (v6.x or later) or **yarn** (v1.x or later)
- **JDK** (Java Development Kit) (v11 or later)
- **Gradle** (v6.x or later)

## Installation

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/marketplace.git
cd marketplace
```

### 2. Install Frontend Dependencies

Navigate to the `react-marketplace` directory and install the required packages:

```bash
cd frontend
npm install
```

### 2. Install Backend Dependencies

Navigate to the backend directory:

```bash
cd ../ktor-marketplace
./gradlew build
```

## Running the Application Locally

### 1. Start the Backend Server

To start the Kotlin backend server:

1. Navigate to the `ktor-marketplace` directory if you haven't already:

   ```bash
   cd backend
   ```
 2. Run the server using Gradle:

    ``` bash
    ./gradlew run
    ```
    The server will start on http://localhost:8080 by default.

### 2. Start the Frontend Development Server
To start the React frontend development server:

1 . Navigate to the frontend directory:
   ``` bash
    cd ../react-marketplace
   ```
2. Start the development server:
   ``` bash
    npm start
   ```
The frontend will start on http://localhost:3000 by default.

### 3. Access the Application
   Once both the frontend and backend servers are running, you can access the application by opening your web browser and navigating to:
http://localhost:3000

## Project Structure

```php
marketplace/
├── react-marketplace/    # React frontend application
│   ├── public/  # Static files
│   ├── src/     # Source files for React components, hooks, and state management
│   ├── package.json  # npm/yarn dependencies and scripts
│   └── ...
├── ktor-marketplace/     # Kotlin backend application
│   ├── src/     # Source files for Ktor routes, services, and models
│   ├── build.gradle.kts  # Gradle build script
│   └── ...
└── README.md  
```

## Future Features
1. Adding a Bid (this is currently WIP)
2. CSS cleanup!