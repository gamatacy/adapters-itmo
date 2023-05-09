<template>
  <b-row align-v="center" class="justify-content-center h-100">
    <b-col cols="12" md="10" lg="8" xl="6">
      <div class="d-flex justify-content-center mb-4 pb-3">
        <img src="/images/logo.png" height="50" alt="Adapters logo">
      </div>
      <b-form class="bg-white rounded py-4 px-4 px-lg-5 mb-4" novalidate @submit="submitForm">
        <div class="text-center text-primary h3 mb-4">
          Войти в систему
        </div>

        <div class="mb-3">
          <b-form-input
            v-model="form.email"
            placeholder="Электронная почта"
            :class="{'is-invalid':!validationEmail}"
          />
          <b-form-invalid-feedback :state="validationEmail">
            Обязательно
          </b-form-invalid-feedback>
        </div>

        <div class="mb-3">
          <b-form-input
            v-model="form.password"
            type="password"
            placeholder="Пароль"
            :class="{'is-invalid':!validationPassword}"
          />
          <b-form-invalid-feedback :state="validationPassword">
            Минимум 12 символов
          </b-form-invalid-feedback>
        </div>

        <!--        <div>-->
        <!--          Забыли пароль?-->
        <!--          <nuxt-link to="/recovery">-->
        <!--            Восстановить-->
        <!--          </nuxt-link>-->
        <!--        </div>-->
        <div class="d-flex justify-content-center mt-4">
          <b-button type="submit" variant="primary" :disabled="loading">
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

  layout: 'empty',

  data: () => ({
    form: {
      email: null,
      password: null
    },
    isTouchedBtn: false,
    loading: false
  }),

  computed: {
    validationPassword () {
      return !this.isTouchedBtn || this.form.password?.length >= 12
    },
    validationEmail () {
      return !this.isTouchedBtn || !!this.form.email
    }
  },

  methods: {
    submitForm (e) {
      e.preventDefault()
      this.isTouchedBtn = true
      if (!this.validationPassword || !this.validationEmail) {
        return
      }
      this.loading = true
      this.$router.push('/events')
      this.loading = false
    }
  }
}
</script>

<style>
.entrance-logo-img {
  height: 50px;
}
</style>
