## Cars

### GET - `/cars`

Gets all the cars in the database

#### Request Body

```
{}
```

#### Response

```
[
    {
        vin: string,
        image?: byte[],
        userEmail: string,
        make: string,
        model: string,
        year: string
        color: string,
        mileage: integer,
        gasTypeId: integer
    },
    ...
]
```

### GET - `/cars/ownedBy/:ownerEmail`

Similar to `get /cars` but only fetches all cars owned by a user by user email

#### arameters

- `ownerEmail` - The email to use to fetch all the cars attached to the email

#### Request Body

```
{}
```

#### Response

```
[
    {
        vin: string,
        image?: byte[],
        userEmail: string,
        make: string,
        model: string,
        year: string
        color: string,
        mileage: integer,
        gasTypeId: integer
    },
    ...
]
```

### POST - `/cars`

#### Request Body

```
{
    vin: string,
    image?: byte[],
    userEmail: string,
    make: string,
    model: string,
    year: string
    color: string,
    mileage: integer,
    gasTypeId: integer
}
```

- `userEmail` needs to be an existing user in the database having the email given.
- `gasTypeId` needs to be an existing gas type in the database.

#### Response

##### HTTP 201 Created

If the resource is created successfully
Outputs the same values as request body if successfull, otherwise 404 if resource can't be found

##### HTTP 429 Conflict

If the resource, the car with the same vin, already exists, it will throw a conflict since no 2 cars will have the same vin number

```
Car with vin <vin> already exists.
```

### PUT - `/cars/:vin`

#### Parameters

- `vin` - The vin number of the car trying to be updated

#### Request Body

```
{
    vin: string,
    image?: byte[],
    userEmail: string,
    make: string,
    model: string,
    year: string
    color: string,
    mileage: integer,
    gasTypeId: integer
}
```

- `vin` cannot be changed.
- `userEmail` needs to be an existing user in the database having the email given.
- `gasTypeId` needs to be an existing gas type in the database.

#### Response

Outputs the same values as request body if successfull, otherwise 404 if resource can't be found

## Gas Type

### GET - `/gas/types`

Gets all gas types

#### Request Body

```
{}
```

#### Response

```
[
    {
        id: integer,
        name: string
    }
]
```

### GET `/gas/types/:id`

Gets a gas type by its id

#### Parameters

- `id` - Gas type id

#### Request Body

```
{}
```

#### Response

```
{
    id: integer,
    name: string
}
```

### GET `/gas/types/name/:name`

Gets a gas type by its name

#### Parameters

- `name` - Name of the gas type

#### Request Body

```
{}
```

#### Response

```
{
    id: integer,
    name: string
}
```

### POST `/gas/types`

Create a new gas type

#### Request Body

```
{
    name: string
}
```

#### Response

```
{
    id: integer,
    name: string
}
```

### PUT `/gas/types/:id`

Edits a gas type (only possible updatable field is name) by its id

#### Parameters

- `id` - The id of the gas type to update

#### Request Body

```
{
    id: integer,
    name: string
}
```

#### Response

The same output as the request body if successfully updated.
