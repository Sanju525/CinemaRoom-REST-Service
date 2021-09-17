# CinemaRoom-REST-Service

## Examples

### 1. a `GET /seats` request

*Response Body*
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

*Response Body*

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

### 3. a `POST /purchase` request, the ticket is already booked

*Request Body*
```
{
    "row": 3,
    "column": 4
}
```

*Response Body*
 ```
 {
    "error": "The ticket has been already purchased!"
}
 ```

### 4. a `POST /return` with the correct token

*Request Body*
```
{
    "token": "bb442e3c-113f-4b7b-85c1-e427f1479f3e"
}
```

*Response Body*
```
{
    "return_ticket": {
        "row": 3,
        "column": 4,
        "price": 10
    }
}
```

### 5. a `POST /stats` request with no parameters

*Response Body*
```
{
    "error": "The password is wrong!"
}
```


### 6. a `POST /stats` request with the correct password

*Response Body*
```
{
    "income": 10,
    "purchasedTickets": 1,
    "availableSeats": 80
}
```

