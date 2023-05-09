<template>
  <NuxtLink class="text-decoration-none" :to="{ path: $route.path+'/' + person.isuNumber}">
    <b-card class="text-center h-100">
      <img :src="photoHandler" alt="photo" class="person-photo rounded">
      <div class="text-body h6 my-1">
        {{ person.name }}
      </div>
      <div class="small text-secondary mt-1">
        {{ person.isuNumber }}
      </div>
      <a :href="'mailto:'+person.email" class="small">
        {{ person.email }}
      </a>
    </b-card>
  </NuxtLink>
</template>

<script>
export default {
  name: 'PersonCard',

  props: {
    person: {
      type: Object,
      default: () => ({})
    }
  },

  computed: {
    photoHandler () {
      if (this.person.avatar) {
        return this.person.avatar
      } else {
        return '/images/default-avatar.svg'
      }
    }
  }
}
</script>

<style scoped>
.person-photo{
  width: 100%;
  max-width: 120px;
  aspect-ratio: 1;
  object-fit: cover;
}
</style>
