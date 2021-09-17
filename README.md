# CinemaRoom-REST-Service

## Examples

### 1. a `GET /seats` request

*Response Body, Status: `200 OK`*
```
{
    "total_rows": 9,
    "total_columns": 9,
    "available_seats": [
        {
            "row": 1,
            "column": 1,
            "price": 10
        },
        {
            "row": 1,
            "column": 2,
            "price": 10
        },
        ...
        {
            "row": 9,
            "column": 9,
            "price": 8
        }
    ]
}
```

### 2. a `POST /purchase` correct request

*Request Body*

 ```
 {
    "row": 3,
    "column": 4
}
 ```

*Response Body, Status: `200 OK`*

```
{
    "token": "bb442e3c-113f-4b7b-85c1-e427f1479f3e",
    "seat": {
        "row": 3,
        "column": 4,
        "price": 10
    }
}
```

### 3. a `POST /stats` request with the correct password

*Response Body, Status: `200 OK`*
```
{
    "income": 10,
    "purchasedTickets": 1,
    "availableSeats": 80
}
```

### 4. a `POST /purchase` request, the ticket is already booked

*Request Body*
```
{
    "row": 3,
    "column": 4
}
```

*Response Body, Status: `400 Bad Request`*
 ```
 {
    "error": "The ticket has been already purchased!"
}
 ```

### 5. a `POST /return` with the correct token

*Request Body*
```
{
    "token": "bb442e3c-113f-4b7b-85c1-e427f1479f3e"
}
```

*Response Body, Status: `200 OK`*
```
{
    "return_ticket": {
        "row": 3,
        "column": 4,
        "price": 10
    }
}
```

### 6. a `POST /stats` request with no parameters

*Response Body, Status: `401 Unauthorized`*
```
{
    "error": "The password is wrong!"
}
```


### 7. a `POST /stats` request with the correct password

*Response Body, Status: `200 OK`*
```
{
    "income": 0,
    "purchasedTickets": 0,
    "availableSeats": 81
}
```

