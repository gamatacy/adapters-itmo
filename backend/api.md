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
Logged out
```

<hr>
<hr>

## Информация о пользователях [ api/users ]

### Получить пользователя по логину

> GET : api/users/test

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

### Получить пользователей

> GET : api/users/page/1

**Ответ:**
```json
 [
  {
    "username": "test",
    "isuNumber": 333580,
    "firstName": "имя_пользователя",
    "middleName": "фамилия_пользователя",
    "lastName": "отчество_пользователя",
    "email": "почта",
    "avatar": "ссылка_на_картинку"
  },
  {
    "username": "test1",
    "isuNumber": 333580,
    "firstName": "имя_пользователя",
    "middleName": "фамилия_пользователя",
    "lastName": "отчество_пользователя",
    "email": "почта",
    "avatar": "ссылка_на_картинку"
  }
]

```

## Мероприятия[ api/users ]

<hr>

### Добавить мероприятие

> POST : api/events/addEvent

**Параметры запроса**
```json
{
  "name" : "test",
  "date" : "2022-03-06 22:00:00",
  "description" : "test event"
}
```

**Ответ**
```json
Event added
```

<hr>

### Получить мероприятия

> GET : api/events/getEvent/{date}

**date - "yyyy-MM-dd"**

**Ответ**
```json
[
    {
        "id": 1,
        "name": "test",
        "description": "test event",
        "date": "2022-03-06 21:00:00",
        "visitors": null,
        "year": 2022,
        "month": 3
    }
]
```
**Ошибка:**
```json
Wrong date format
```