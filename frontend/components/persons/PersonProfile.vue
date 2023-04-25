<template>
  <b-overlay :show="isLoading" class="h-100">
    <div v-if="person">
      <b-row>
        <b-col cols="12" lg="auto">
          <img :src="photoHandler" alt="photo" class="profile-photo rounded">
        </b-col>
        <b-col cols="12" lg>
          <div class="d-flex align-items-end mb-2">
            <div class="h4 mb-0">
              {{ person.name }}
            </div>
            <div class="border-left pl-2 ml-2 text-secondary">
              {{ person.isuNumber }}
            </div>
          </div>
          <div>{{ person.admin?'организатор':'участник' }} школы</div>
          <a :href="'mailto:'+person.email" class="small">
            {{ person.email }}
          </a>
          <hr class="mb-2">
          <b-badge v-for="(hobby,i) in person.hobbies" :key="i" class="mr-2 mt-2">
            {{ hobby }}
          </b-badge>
        </b-col>
      </b-row>
      <hr class="mb-2">
      <div class="h4">
        Достижения
      </div>
    </div>
  </b-overlay>
</template>

<script>
export default {
  name: 'PersonProfile',

  props: {
    person: {
      type: Object,
      default: () => ({})
    },
    isLoading: {
      type: Boolean,
      default: false
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

</style>
