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

**Успешный ответ:**
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

**Успешный ответ:**
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

**Успешный ответ:**
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

**Успешный ответ:**
```json
{
  "message" : "Logged out"
}
```

<br>