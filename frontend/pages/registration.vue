<template>
  <b-row align-v="center" class="justify-content-center h-100">
    <b-col cols="12" md="10" lg="8" xl="6">
      <div class="d-flex justify-content-center pb-3 my-4">
        <img src="/images/logo.png" height="50" alt="Adapters logo">
      </div>
      <b-form class="bg-white rounded py-4 px-4 px-lg-5 mb-4" novalidate @submit="submitForm">
        <div class="text-center text-primary h3 mb-4">
          Регистрация участника
        </div>

        <div class="mb-3">
          <b-form-input
            v-model="form.lastName"
            placeholder="Фамилия"
            :class="{'is-invalid':!validationLastName}"
          />
          <b-form-invalid-feedback :state="validationLastName">
            Обязательно
          </b-form-invalid-feedback>
        </div>

        <div class="mb-3">
          <b-form-input
            v-model="form.firstName"
            placeholder="Имя"
            :class="{'is-invalid':!validationFirstName}"
          />
          <b-form-invalid-feedback :state="validationFirstName">
            Обязательно
          </b-form-invalid-feedback>
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

        <div class="mb-3 pb-2">
          <b-form-input
            v-model="form.passwordConfirm"
            type="password"
            placeholder="Повторите пароль"
            :class="{'is-invalid':!validationPasswordConfirm}"
          />
          <div>
            <b-form-invalid-feedback :state="validationPasswordConfirmRequired">
              Минимум 12 символов
            </b-form-invalid-feedback>
          </div>
          <b-form-invalid-feedback :state="validationPasswordConfirm">
            Не совпадает с паролем
          </b-form-invalid-feedback>
        </div>

        <b-form-checkbox>
          Я уже проходил школу Адаптера
        </b-form-checkbox>

        <b-form-checkbox>
          Я даю согласие на обработку своих персональных данных
        </b-form-checkbox>

        <div class="d-flex justify-content-center mt-4">
          <b-button variant="primary" type="submit">
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

  layout: 'empty',

  data: () => ({
    form: {
      firstName: null,
      lastName: null,
      email: null,
      password: null,
      passwordConfirm: null
    },
    isTouchedBtn: false,
    loading: false
  }),

  computed: {
    validationFirstName () {
      return !this.isTouchedBtn || this.form.firstName?.length
    },
    validationLastName () {
      return !this.isTouchedBtn || this.form.lastName?.length
    },
    validationPassword () {
      return !this.isTouchedBtn || this.form.password?.length >= 12
    },
    validationPasswordConfirmRequired () {
      return !this.isTouchedBtn || this.form.passwordConfirm?.length >= 12
    },
    validationPasswordConfirm () {
      return !this.isTouchedBtn || this.form.passwordConfirm?.length < 12 || this.form.password === this.form.passwordConfirm
    },
    validationEmail () {
      return !this.isTouchedBtn || !!this.form.email
    }
  },

  methods: {
    submitForm (e) {
      e.preventDefault()
      this.isTouchedBtn = true
      if (!this.validationPassword || !this.validationEmail || !this.validationPasswordConfirm ||
        !this.validationFirstName || !this.validationLastName) {
        return
      }
      this.loading = true
      //
      this.loading = false
    }
  }
}
</script>

<style scoped>

</style>
