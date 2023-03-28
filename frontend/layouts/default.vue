<template>
  <div>
    <TheHeader />
    <TheSidebar />
    <b-container class="mt-3 px-2 px-lg-0">
      <div class="bg-white rounded p-2 px-3 p-lg-4 px-lg-5">
        <Nuxt />
      </div>
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
