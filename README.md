# HTTP Request Handler (Task Manager) with REST API

Key Features of the Handler 🛠️
--
- RESTful Endpoints: The controller exposes several endpoints under the base path /tasks to handle different HTTP requests.
- Dependency Injection: It uses Spring's @Autowired annotation to inject an instance of the TaskRepository, which allows the controller to interact with the database.
- CRUD Operations: The controller provides the following functionalities for managing tasks:
- Create Task (POST /tasks): Accepts a JSON object in the request body and saves it as a new task in the database.
- Get All Tasks (GET /tasks): Retrieves and returns a list of all tasks stored in the database.
- Update Task (PUT /tasks/{id}): Updates an existing task by its ID with the data provided in the request body. If the task doesn't exist, it creates a new one.

How It Works ⚙️
--
The handler is built on the Spring Framework and leverages Spring Data JPA to handle database interactions. Instead of writing raw SQL queries, the TaskRepository interface provides predefined methods like findAll(), save(), and deleteById() that perform the necessary database operations.

The @RestController and @RequestMapping annotations are what make this class a web handler. They tell Spring to automatically handle incoming HTTP requests and map them to the correct methods within the class. This design follows the REST architectural style, making it a common pattern for building web APIs.


Using Postman 🚀
--
- Creating Data (POST): To add a new task, send a POST request to http://localhost:8080/tasks. Set the Content-Type header to application/json and include a JSON body with the task's title and description. The database will automatically generate an ID for the new task.
- Updating Data (PUT): To update an existing task, send a PUT request to http://localhost:8080/tasks/{id}, replacing {id} with the ID of the task you want to modify. Just like with the POST request, set the Content-Type header to application/json and include a JSON body with the updated title and description.
- Deleting Data (DELETE): To remove a task, send a DELETE request to http://localhost:8080/tasks/{id}, replacing {id} with the ID of the task you want to delete. There's no need to include a request body for this operation.
