### Collateral loans Risk assessment

### Steps

- Download the zip file of Collateral Loans-risk assessment
-  Extract the zip file.
-  Import the file into spring tool suite.
- Open port localhost:9090/portal/login
-  Login as user  
- Enter the username:user and password:user
-  Create a loan by entering the required details.
-  Check the status in applied loan.
-  Logout from the customer page.
- Now login as Admin with the credentials ( username: admin and password: admin)
- Go to accept/reject application. Accept the required loan.
- Move to activities page and go to customer loan details.
- Enter the loan Id, customer Id in order to fetch the necessary details.
- Go to activities page and open "Save the collateral details"
- Either choose cash/real estate and enter the details and save them.
- Go to activities and click to open risk management.
- Enter the loan id and fetch the risk details.
- Click on "Check collateral details" and enter the loan id to fetch the collateral details.
- Logout from the portal.

### Database ports 

##### Authorization 
- Port : http://localhost:8081/auth/h2-console
- Driver Class : org.h2.Driver
- JDBC url : jdbc:h2:mem:auth

##### Loan 
- Port : http://localhost:8100/loan/db
- Driver Class : org.h2.Driver
- JDBC url : jdbc:h2:mem:loan

##### Collateral 
- Port : http://localhost:8000/collateral/db
- Driver Class : org.h2.Driver
- JDBC url : jdbc:h2:mem:collateral

##### Risk 
- Port : http://localhost:8082/risk/db
- Driver Class : org.h2.Driver
- JDBC url : jdbc:h2:mem:risk

##### Portal 
- Port : http://localhost:9090/portal/login

