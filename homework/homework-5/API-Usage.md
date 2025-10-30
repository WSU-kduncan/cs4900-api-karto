# API-Usage

Joshua Wise

## Users

### GET - `/users`

Get all users from the database

#### Request Body

```
{}
```

#### Response

```
[
    {
        "email": "user.user1@exammple.text",
        "username": "user1",
        "createdAt": "2025-10-21716:50:142",
        "trustedGasStationIds": []
    },
    {
        "email": "user.user2@exammple.text",
        "username": "user2",
        "createdAt": "2025-10-21716:50:142",
        "trustedGasStationIds": []
    },
    {
        "email": "user.user3@exammple.text",
        "username": "user3",
        "createdAt": "2025-10-21716:50:142",
        "trustedGasStationIds": []
    },
]
```

### GET - `/users/:email`

Get user by email

#### Request Body

```
{
    "email": "userToGrab@example.test"
}
```

#### Response

```
{
    "email": "userToGrab@example.test",
    "username": "user4",
    "createdAt": "2025-10-21716:50:142",
    "trustedGasStationIds": []
}
```

### GET - `/users/:username`

Get user by username

#### Request Body

```
{
    "username": "user4"
}
```

#### Response

```
    "email": "userToGrab@example.test",
    "username": "user4",
    "createdAt": "2025-10-21716:50:142",
    "trustedGasStationIds": []
```

### Gas Stations

### GET - `/gasstaion`

#### Request Body

```
{}
```

#### Response

```
[
    {
        "id": 1,
        "longitude": 0.661911,
        "latitude": 0.150963,
        "name": "Spec Marathon",
        "addressLine": "1",
        "city": "Inglewood",
        "state": "Ohio",
        "zip": "1234567",
        "userEmails": [
            "example.joe@example.test"
            "example.bob@example.test"
            "example.ned@example.test"
        ]
    },
    {
        "id": 2,
        "longitude": 0.661911,
        "latitude": 0.150963,
        "name": "Speed Way",
        "addressLine": "2",
        "city": "Sidney",
        "state": "Ohio",
        "zip": "1234567",
        "userEmails": [
            "example.joe@example.test"
            "example.bob@example.test"
            "example.ned@example.test"
        ]
    },
]
```

### GET - `gasstation/:id`

#### Request Body

```
{
    "id": 1,
}
```

#### Response

```
{
    "id": 1,
    "longitude": 0.661911,
    "latitude": 0.150963,
    "name": "Spec Marathon",
    "addressLine": "1",
    "city": "Inglewood",
    "state": "Ohio",
    "zip": "1234567",
    "userEmails": [
       "example.joe@example.test"
        "example.bob@example.test"
        "example.ned@example.test"
    ]
}

```

### GET - `gasstation/:name`

#### Request Body

```
{
    "name": "Spec Marathon"
}
```

#### Response

```
{
    "id": 1,
    "longitude": 0.661911,
    "latitude": 0.150963,
    "name": "Spec Marathon",
    "addressLine": "1",
    "city": "Inglewood",
    "state": "Ohio",
    "zip": "1234567",
    "userEmails": [
       "example.joe@example.test"
        "example.bob@example.test"
        "example.ned@example.test"
    ]
}
```
