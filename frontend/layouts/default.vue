<template>
  <b-container style="height: 100vh">
    <TheHeader />
    <Nuxt />
  </b-container>
</template>

<script>
export default {
  name: 'DefaultLayout',
  components: {
    TheHeader: () => import('../components/application/TheHeader')
  },
  methods: {}
}
</script>

<style>
body {
  background: #F1F1F1;
}
</style>
