<template>
  <b-row align-v="center" class="justify-content-center h-100">
    <b-col cols="12" md="10" lg="8" xl="6">
      <div class="d-flex justify-content-center mb-4 pb-3">
        <img src="/images/logo.png" height="50" alt="Adapters logo">
      </div>
      <b-form class="bg-white rounded py-4 px-4 px-lg-5 mb-4">
        <div class="text-center text-primary h3 mb-4">
          Войти в систему
        </div>

        <b-form-input
          placeholder="Электронная почта"
          class="mb-3"
        />

        <b-form-input
          type="password"
          placeholder="Пароль"
          class="mb-3 pb-2"
        />

        <div>
          Забыли пароль?
          <nuxt-link to="/recovery">
            Восстановить
          </nuxt-link>
        </div>
        <div class="d-flex justify-content-center mt-4">
          <b-button variant="primary">
            Вход
          </b-button>
        </div>
        <div class="text-center mt-2">
          Нет аккаунта?
          <nuxt-link to="/registration">
            Зарегестрироваться
          </nuxt-link>
        </div>
      </b-form>
    </b-col>
  </b-row>
</template>

<script>
export default {
  name: 'LoginPage',
  layout: 'empty'
}
</script>

<style>
.entrance-logo-img {
  height: 50px;
}
</style>
