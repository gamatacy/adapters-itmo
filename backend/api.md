# API Docs
## Аутентификация [ api/auth ]
<hr>

### Регистрация пользователя 

> POST : api/auth/registration

**Параметры запроса:**
```json
{
  "username":"ник_пользователя",
  "firstName":"имя_пользователя",
  "middleName":"фамилия_пользователя",
  "lastName":"отчество_пользователя",
  "isuNumber":"номер_ису",
  "password":"пароль",
  "email":"почта",
  "avatar":"ссылка_на_картинку"
}
```

**Ответ:**
```json
{
  "message" : "Successful registration",
  "accessToken" : "token"
}
```

**Ошибка:**
```json
{
  "message" : "Account with this username already exist"
}
```

<hr>

### Авторизация пользователя

> POST : api/auth/login

**Параметры запроса:**
```json
{
  "username":"ник_пользователя",
  "password":"пароль"
}
```

**Ответ:**
```json
{
  "message" : "Logged in",
  "accessToken" : "token"
}
```

**Ошибка:**
```json
{
  "message" : "Account with this username doesn't exist"
}
```

<hr>

### Обновление токена

> GET : api/auth/refresh

**Ответ:**
```json
{
  "message" : "Token refreshed",
  "accessToken" : "token"
}
```

**Ошибка:**
```json
{
  "message" : "Token expired"
}
```

<hr>

### Логаут (удаление токена из кук)

> GET : api/auth/logout

**Ответ:**
```json
{
  "message" : "Logged out"
}
```

<hr>
<hr>

## Информация о пользователях [ api/users ]

### Получить пользователя по логину

> GET : api/users/?username=test

**Ответ:**
```json
{
  "username" : "test",
  "isuNumber" : "333580",
  "firstName" :  "Oleg",
  "middleName" : "Igorevich", 
  "lastName" :  "Shipulin",
  "email" : "oleg@mail.ru",
  "avatar" : "url"
}
```

**Если пользователь не найден - возвращает 404**

<hr>

### Получить пользователя по логину

> GET : api/users/?username=test

**Ответ:**
```json
  "data": [
    {
    "username": "john_smith",
    "isuNumber": "12345",
    "firstName": "John",
    "middleName": "Doe",
    "lastName": "Smith",
    "email": "john.smith@example.com",
    "avatar": "https://example.com/avatar.png"
    },
    {
    "username": "jane_doe",
    "isuNumber": "67890",
    "firstName": "Jane",
    "middleName": "Doe",
    "lastName": "Smith",
    "email": "jane.doe@example.com",
    "avatar": "https://example.com/avatar.png"
    }
]

```


<hr>