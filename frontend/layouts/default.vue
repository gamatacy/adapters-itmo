<template>
  <div>
    <TheHeader />
    <TheSidebar />
    <b-container>
      <Nuxt />
    </b-container>
  </div>
</template>

<script>
export default {
  name: 'DefaultLayout',

  components: {
    TheSidebar: () => import('../components/application/TheSidebar'),
    TheHeader: () => import('../components/application/TheHeader')
  }
}
</script>

<style>
</style>
