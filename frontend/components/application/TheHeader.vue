<template>
  <b-navbar toggleable="lg">
    <b-navbar-brand href="/">
      <img src="/images/logo.png" alt="Adapters logo">
    </b-navbar-brand>

    <b-navbar-toggle target="nav-collapse" />

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav class="ml-auto">
        <b-nav-item-dropdown text="Люди" right>
          <b-dropdown-item href="/persons/members">
            Участники
          </b-dropdown-item>
          <b-dropdown-item href="/persons/organizers">
            Организаторы
          </b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown text="Материалы" right>
          <b-dropdown-item href="/materials/reminders">
            Памятки
          </b-dropdown-item>
          <b-dropdown-item href="/materials/tests">
            Тесты
          </b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-item href="/events">
          Актуальное
        </b-nav-item>

        <b-nav-item href="/profile">
          Профиль
        </b-nav-item>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</template>

<script>
export default {
  name: 'TheHeader'
}
</script>

<style scoped>
.navbar-brand img{
  height: 30px;
}
</style>
