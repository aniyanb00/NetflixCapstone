# NetflixCapstone
Challenge: Game Store Project
For their capstone project, students apply the full extent of the skills they’ve learned in the bootcamp to deploy a final project, working independently or in groups to take a concept from specification to deployment.
This project involves creating a simple database backed REST inventory management web service for a Video Game Store using Agile development techniques in a solo setting. You are responsible for designing and documenting the REST API and implementing the controller, service layer, DAO, Java data objects, and unit tests for the application based on an existing database structure.
Students will also be able to add their project and capstone to their own Github portfolios. The skills covered within this course will help them as they prepare for interviews and internships!

**Structure**
Your solution must have the following structural elements:

Your solution must be in an IntelliJ project called FirstNameLastNameCapstone where FirstName and LastName are your first and last names respectively.
Your project must be built using Spring Boot and Spring MVC. Initialize your project using start.spring.io
Your solution must include a DAO that utilizes JdbcTemplates and Prepared Statements
Your REST API must be documented with Swagger
Your REST API must accept and return data in JSON format where appropriate
You must implement ControllerAdvice to handle exceptions and return proper HTTP status codes and data when exceptions occur. This includes handling all violations of business rules.

**
**Methodology****

You must manage your work in Pivotal Tracker
You must create stories and epics
You must estimate your work using story points
You must use a Test Driven Development approach (including Red/Green/Refactor) for your code
You must use JUnit for unit and integration tests
Your design must include a Service Layer
Your unit test suite should utilize mock objects where appropriate
You should utilize JSR303 for input validation


**Requirements/Features**
This system must manage the inventory of video games, game consoles, and t-shirts.
Your REST API must allow the end user to:
**
**Games:****

Perform standard CRUD operations for Games
Search for Games by Studio
Search for Games by ESRB Rating
Search for Games by Title
You must create a separate DAO for Games


**Consoles:**

Perform standard CRUD operations for Consoles
Search for Consoles by Manufacturer
You must create a separate DAO for Consoles


**T-Shirts:**

Perform standard CRUD operations for T-Shirts
Search for T-Shirts by Color
Search for T-Shirts by Size
You must create a separate DAO for T-Shirts


**Purchasing Items (Invoice Creation):**

User should be able to purchase items in inventory by supplying the following information to the endpoint:

Name
Street
City
State
Zip
Item Type
Item ID
Quantity


The endpoint returns invoice data based on the invoice table below.
All invoice calculations must be done in the Service Layer.
You must create a DAO for both taxes and processing fees.



**Test Requirements**

- You must test all routes using MockMVC.
- This includes testing for both expected return values, and expected controller failures (4xx and 5xx status codes)
- Test all service layer methods
- You should have 100% code coverage of the service layer
-These should be unit tests—in other words, they should employ mocking
-You must have integration tests for all DAOs
-These should test the basic CRUD operations
-It should also test any custom methods you've defined (such as findByCategory)


**Business Rules**

- Sales tax applies only to the cost of the items.
- Sales tax does not apply to any processing fees for an invoice.
- The processing fee is applied only once per order regardless of the number of items in the order unless the number of items on the order is greater than 10 in which case an additional processing fee of $15.49 is applied to the order.
- The order process logic must properly update the quantity on hand for the item in the order.
- Order quantity must be greater than zero.
- Order quantity must be less than or equal to the number of items on hand in inventory.
- Order must contain a valid state code.
- The REST API must properly handle and report all violations of business rules.


