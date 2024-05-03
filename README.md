<b>Language, Framework and Tools:</b>
</br>
</br>
  Java 17
  </br>
  Spring Boot 3.2.2
  </br>
  Gradle 8.6
  </br>
  Docker 25.0.3
  </br>
  IntelliJ IDE Community Edition
  </br>
</br>

<b>Features:</b>
</br>
</br>
  Global exception handling
  </br>
  Centralized exception handling for all APIs
  </br>
  Log visualization with Loki and Grafana
  </br>
  API documentation with OpenApi specification
  </br>
  Initialized with random data to test API
  </br>
  Local log file
  </br>
  API Unit testing
  </br></br>

<b>Build:</b>
  </br>
    gralde build
</br></br>

<b>Run:</b>
</br>
  gradle bootRun
  </br>
</br>
<b>Docker:</b>
</br>
  gradle build
  </br>
  gradle dockerRun
</br></br>
or
</br></br>
  docker build .
  </br>
  docker-compose up
</br></br>
</br>
<b>Swagger Url:</b>
</br>
  http://localhost:8080/swagger-ui/index.html

</br>
<b> Known issue: </b>
  </br>
  first <b>build</b> the project before running <b> docker-compose</b>

  </br></br>

<b> APIs: </b>
</br></br>

<b>
POST  /ap/v1/carts/add-to-cart
</b>
</br>
Add items to a user's cart
</br></br>

<b>
GET   /api/v1/carts/view-cart/{id}
</b>
</br>
Get the user's cart items
</br></br>

<b>
POST   /api/v1/orders/place-order
</b>
</br>
Place an order for a user. All items of the user's cart will be sold for the user
</br></br>

<b>
POST  /api/v1/sales/max-sale-day
</b>
</br>
Returns the maximum sale date  of a certain time range
</br></br>

<b>
GET  /api/v1/sales/total/amount
</b>
</br>
Get total sale amount of the current date
</br></br>

<b>
GET /api/v1/sales/top-five-selling-item-by-quantity
</b>
</br>
Returns the top 5 selling items of <b>last month</b> based on number of sales
</br></br>

<b>
GET /api/v1/sales/top-five-selling-item-by-amount
</b>
</br>
Returns the top 5 selling items of all time based on total sale amount
</br>
