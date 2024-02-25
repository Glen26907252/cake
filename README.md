# Cake

| Eclipse BackEnd packages        | Framework        | VsCode FrontEnd packages           |
|-----------------|-------------------|-------------------|
| UserProject | SprintBoot+ORM(JPA) | Exam  |
| UserProject | SprintBoot+ORM(JPA) | user-app    |
| UserProject | SprintBoot+ORM(JPA) | cake-app    |
| UserProject2 | SprintBoot+ORM(mybatis) | ex1-app  |
| Jpa-2 | SprintBoot+ORM(JPA)      | N/A               |
| UserProject2 | SprintBoot+ORM(mybatis) | cake-app  |

# Starting the React Project(cake-app)

To start the project in React, follow these steps:

1. Open the command line terminal.
2. Navigate to the root directory of your React project by using the `cd` command followed by the directory name. For example:
    ```bash
    cd cake-app
    ```
3. Once you are in the root directory of your React project, start the development server by running the following command:
    ```bash
    npm start
    ```
4. After running the command, your default web browser should open automatically, and you should see your React application running. If it doesn't open automatically, you can manually open a web browser and navigate to `http://localhost:3000` to view your application.

# Starting the Eclipse Project

Project: bootRs

Sub-Projects: UserProject , UserProject2

In the `bootRs` project, there are two different ORM writing styles:

- **UserProject** follows the JPA approach.
- **UserProject2** follows the MyBatis approach.

To start the project in Eclipse, follow these steps:

For JPA-based server startup:

1. Locate the `UserProjectApplication.java` file within the `bootRs` project.
2. Right-click on `UserProjectApplication.java`.
3. Select "Run As" > "Spring Boot App" to start the server.

For MyBatis-based server startup:

1. Locate the `UserProject2Application.java` file within the `bootRs` project.
2. Right-click on `UserProject2Application.java`.
3. Select "Run As" > "Spring Boot App" to start the server.

