# API Routes

### Maintenance Controller ([/maintenance/](./src/main/java/com/karto/service/controller/MaintenanceController.java))

- **GET** - all maintenances
- **GET** - maintenance by id
- **GET** - all maintenances by car VIN
- **GET** - all maintenance types
- **GET** - maintenance statistics by car
- **PUT** - maintenance 
- **POST** - maintenance
- **DELETE** - maintenance by id

### Car Controller ([/cars/](./src/main/java/com/karto/service/controller/CarController.java)) 

- **GET** - all cars
- **GET** - all cars by VIN
- **GET** - all cars by owner email
- **PUT** - update car by VIN
- **POST** - add a new car

### Gas Controller ([/gas/](./src/main/java/com/karto/service/controller/GasController.java))

- **GET** - all gas types
- **GET** - gas type by id
- **GET** - gas type by name
- **PUT** - update gas name
- **POST** - create new gas type

- **GET** - all gas prices
- **GET** - gas price by id
- **GET** - gas price by gas type name
- **PUT** - update gas price
- **POST** - save gas price

- **GET** - users by trusted gas station id

### User Controller ([/user/](./src/main/java/com/karto/service/controller/UserController.java))

- **GET** - all users
- **GET** - users by id
- **GET** - users by username
- **PUT** - update user
- **POST** - create new users
- **POST** - login with email and password

- **GET** - trusted gas stations by user email
- **POST** - add a new trusted gas station
- **PUT** - update trusted gas station
- **DELETE** - remove a trusted gas station

### Gas Station Controller ([/gasstation/](./src/main/java/com/karto/service/controller/GasStationController.java))

- **GET** - all gas stations
- **GET** - gas station by id
- **GET** - gas station by name
- **GET** - gas station by trusted
- **PUT** - update gas station
- **POST** - create new gas station
