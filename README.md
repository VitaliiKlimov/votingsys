### Restaurant voting.

Enterprise java REST application project for build a voting system for deciding where to have a lunch.

    Application logic:
     - 2 types of users: admin and regular users
     - Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
     - Menu changes each day (admins do the updates)
     - Users can vote on which restaurant they want to have lunch at
     - Only one vote counted per user
     - If user votes again the same day:
     - If it is before 11:00 we assume that he changed his mind.
     - If it is after 11:00 then it is too late, vote can't be changed
     - Each restaurant provides a new menu each day.
     
##### Technology stack: Maven, Spring Security, JPA (Hibernate), Spring Security Test, Hibernate Validator, Json Jackson, Apache Tomcat, HSQLDB, JUnit, Hamcrest.

### curl samples for test REST interface (application deployed at application context `votingsys`).
> For windows use `Git Bash`

### AdminRestController test:

#### get All Users
`curl -s http://localhost:8080/votingsys/rest/admin/users --user admin@gmail.com:admin`

#### get Users 100001
`curl -s http://localhost:8080/votingsys/rest/admin/users/100001 --user admin@gmail.com:admin`

#### create User
`curl -s -i -X POST -d '{"name":"New User","email":"test@mail.ru","password":"test-password"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsys/rest/admin/users --user admin@gmail.com:admin`

#### get User by email
`curl -s http://localhost:8080/votingsys/rest/admin/users/by?email=user@yandex.ru --user admin@gmail.com:admin`

#### update User data
`curl -s -X PUT -d '{"name": "UserUpdated", "email": "user@yandex.ru", "password": "passwordNew", "roles": ["USER"]}' -H 'Content-Type: application/json' http://localhost:8080/votingsys/rest/admin/users/100000 --user admin@gmail.com:admin`

#### delete User 100000
`curl -s -X DELETE http://localhost:8080/votingsys/rest/admin/users/100000 --user admin@gmail.com:admin`

### ProfileRestController test:

#### Register new User
`curl -i -X POST -d '{"name":"New User","email":"test@gmail.com","password":"test-password"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsys/rest/profile/register`

#### Get current User data from profile
`curl -s http://localhost:8080/votingsys/rest/profile --user user@yandex.ru:password`

####  Update User data
`curl -s -X PUT -d '{"name": "UserUpdated", "email": "user@yandex.ru", "password": "passwordNew", "roles": ["USER"]}' -H 'Content-Type: application/json' http://localhost:8080/votingsys/rest/profile --user user@yandex.ru:password`

#### Delete User data
`curl -s -X DELETE http://localhost:8080/votingsys/rest/profile --user user@yandex.ru:password`

### AdminDishRestController test:

#### Create new dish
`curl -s -i -X POST -d '{"description": "Mashrooms","date": "2020-12-21","price": 100,"restaurantId": 100002}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsys/rest/admin/dishes --user admin@gmail.com:admin`

#### Get all dishes
`curl -s http://localhost:8080/votingsys/rest/admin/dishes --user admin@gmail.com:admin`

#### Update dish 100006
`curl -s -X PUT -d '{"id":100006, "description":"Roasted fish", "price":1700}' -H 'Content-Type: application/json' http://localhost:8080/votingsys/rest/admin/dishes/100006 --user admin@gmail.com:admin`

#### Delete dish 100007
`curl -s -X DELETE http://localhost:8080/votingsys/rest/admin/dishes/100007 --user admin@gmail.com:admin`

### AdminRestaurantRestController Test

#### Create restaurant
`curl -s -i -X POST -d '{"name":"Best place"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsys/rest/admin/restaurants --user admin@gmail.com:admin`

#### Get all restaurants
`curl -s http://localhost:8080/votingsys/rest/admin/restaurants --user admin@gmail.com:admin`

#### Get restaurant 100002
`curl -s http://localhost:8080/votingsys/rest/admin/restaurants/100002 --user admin@gmail.com:admin`

#### Update restaurant 100002
`curl -s -X PUT -d '{"id":100002, "name":"Chicken palace"}' -H 'Content-Type: application/json' http://localhost:8080/votingsys/rest/admin/restaurants/100002 --user admin@gmail.com:admin`

#### Delete restaurant 100002
`curl -s -X DELETE http://localhost:8080/votingsys/rest/admin/restaurants/100002 --user admin@gmail.com:admin`

### UserRestaurantRestController test

#### Get all restaurants
`curl -s http://localhost:8080/votingsys/rest/user/restaurants --user user@yandex.ru:password`

#### Get restaurant 100002
`curl -s http://localhost:8080/votingsys/rest/user/restaurants/100002 --user user@yandex.ru:password`

#### Get actual dishes for restaurant 100002
`curl -s http://localhost:8080/votingsys/rest/user/restaurants/100002/dishes --user user@yandex.ru:password`

#### Vote for restaurant 100002
`curl -s -i -X POST -d '{"id":100002}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/votingsys/rest/user/restaurants --user user@yandex.ru:password`
