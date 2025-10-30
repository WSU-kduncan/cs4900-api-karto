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

### POST - `/user`

Create user

#### Request Body

```
{
    "email": "test@test.com"
    "username": "ThisisaTest"
    "password": "asdasjlkfrhgqfeqfq"
}

```

#### Response

```
{
    "email": "test@test.com"
    "username": "ThisisaTest"
    "password": "asdasjlkfrhgqfeqfq"
    "createdAt": "2025-10-28T02:24:49Z"
}

```

### PUT - `/user/:id`

Update a user

#### Request Body

```
{
    "email": "changeTest@test.com"
    "username": "ThisisaTest"
    "password": "asdasjlkfrhgqfeqfq"
}
```

#### Response

```
{
    "email": "changeTest@test.com"
    "username": "ThisisaTest"
    "password": "asdasjlkfrhgqfeqfq"
}
```

## Gas Stations

### GET - `/gasstaion`

Get All Gas Stations

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

Search Gas Stations by Id

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

Search Gas Stations by Name

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

### POST - `gasstation/`

Create gasstaion

#### Request Body

```
{
    "longitude": .52987,
    "latitude": .351804,
    "name": "Some Station",
    "addressLine": "4",
    "city": "Sidney",
    "state": "Ohio",
    "zip": "1234567",
}
```

#### Response

```
{
    "id": 11,
    "longitude": .52987,
    "latitude": .351804,
    "name": "Some Station",
    "addressLine": "4",
    "city": "Sidney",
    "state": "Ohio",
    "zip": "1234567",
}
`
```

### PUT - `gasstation/:id`

Update Gas Station

#### Request Body

```
{
    "longitude": .52987,
    "latitude": .351804,
    "name": "Some Station",
    "addressLine": "4",
    "city": "Not Sidney",
    "state": "Ohio",
    "zip": "1234567",
}
```

#### Response

```
{
    "longitude": .52987,
    "latitude": .351804,
    "name": "Some Station",
    "addressLine": "4",
    "city": "Not Sidney",
    "state": "Ohio",
    "zip": "1234567",
}
```
