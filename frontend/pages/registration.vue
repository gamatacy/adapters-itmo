<template>
  <b-row align-v="center" class="justify-content-center h-100">
    <b-col cols="12" md="10" lg="8" xl="6">
      <div class="d-flex justify-content-center pb-3 my-4">
        <img src="/images/logo.png" height="50" alt="Adapters logo">
      </div>
      <b-form class="bg-white rounded py-4 px-4 px-lg-5 mb-4">
        <div class="text-center text-primary h3 mb-4">
          Регистрация участника
        </div>

        <b-form-input
          placeholder="Фамилия"
          class="mb-3"
        />

        <b-form-input
          placeholder="Имя"
          class="mb-3"
        />

        <b-form-input
          placeholder="Электронная почта"
          class="mb-3"
        />

        <b-form-input
          type="password"
          placeholder="Пароль"
          class="mb-3"
        />

        <b-form-input
          type="password"
          placeholder="Повторите пароль"
          class="mb-3"
        />

        <b-form-checkbox>
          Я уже проходил школу Адаптера
        </b-form-checkbox>

        <b-form-checkbox>
          Я даю согласие на обработку своих персональных данных
        </b-form-checkbox>

        <div class="d-flex justify-content-center mt-4">
          <b-button variant="primary">
            Регистрация
          </b-button>
        </div>

        <div class="d-flex justify-content-center">
          <b-button to="/login" variant="link">
            Назад
          </b-button>
        </div>
      </b-form>
    </b-col>
  </b-row>
</template>

<script>
export default {
  name: 'RegistrationPage',
  layout: 'empty'
}
</script>

<style scoped>

</style>
