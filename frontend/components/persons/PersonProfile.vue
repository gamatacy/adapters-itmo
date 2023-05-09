<template>
  <b-overlay :show="isLoading" class="h-100">
    <div v-if="person">
      <b-row>
        <b-col cols="12" lg="auto" class="d-flex justify-content-center d-lg-block">
          <img :src="photoHandler" alt="photo" class="profile-photo rounded">
        </b-col>
        <b-col cols="12" lg class="text-center text-lg-left">
          <div class="d-lg-flex align-items-end mb-2">
            <div class="h4 mb-0">
              {{ person.name }}
            </div>
            <div class="profile-isu pl-2 ml-2 text-secondary">
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
          <div class="profile-logout">
            <slot name="logout" />
          </div>
        </b-col>
      </b-row>
      <hr class="mb-2">
      <div class="h4 mb-3">
        Достижения
      </div>

      <div v-if="person.achievements.length" :class="navigationEnabled?'px-3':'mx--1'">
        <client-only>
          <carousel v-bind="options" :navigation-enabled="navigationEnabled">
            <slide v-for="(achievement,i) in person.achievements" :key="i" class="img-wrapper">
              <b-card class="text-center h-100 mx-2">
                <div class="d-flex flex-column justify-content-between h-100">
                  <div class="h6">
                    Пройден
                    {{ achievement.name }}
                  </div>
                  <div>
                    {{ $dayjs(achievement.date).format('DD.MM.YYYY') }}
                  </div>
                </div>
              </b-card>
            </slide>
          </carousel>
        </client-only>
      </div>
      <div v-else>
        <div class="d-flex justify-content-center">
          <img src="/adapters/images/404.svg" height="150" alt="404">
        </div>
        <div class="text-center mt-2">
          Не найдено
        </div>
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

  data () {
    return {
      options: {
        loop: true,
        perPage: 5,
        perPageCustom: [[0, 1], [992, 4]],
        paginationActiveColor: 'var(--primary)',
        paginationEnabled: false,
        navigationPrevLabel: '<svg viewBox="0 0 16 16" width="1em" height="1em" focusable="false" role="img" aria-label="chevron left" xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi-chevron-left b-icon bi"><g><path fill-rule="evenodd" d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"></path></g></svg>',
        navigationNextLabel: '<svg viewBox="0 0 16 16" width="1em" height="1em" focusable="false" role="img" aria-label="chevron right" xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi-chevron-right b-icon bi"><g><path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"></path></g></svg>'
      }
    }
  },

  computed: {
    photoHandler () {
      if (this.person.avatar) {
        return this.person.avatar
      } else {
        return '/adapters/images/default-avatar.svg'
      }
    },
    navigationEnabled () {
      return window.innerWidth >= 992 && this.person.achievements.length > 3
    }
  }
}
</script>

<style lang="scss">
.profile-photo{
  width: 100%;
  max-width: 150px;

  @media (min-width: 992px) {
    max-width: 250px;
  }
}

.profile-isu{
  @media (min-width: 992px) {
    border-left: 1px solid rgba(0, 0, 0, 0.1);
  }
}

.profile-logout{
  position: absolute;
  top:0;
  right: 0;
}

.VueCarousel-navigation-button{
  border-radius: 10px;
}
.mx--1{
  margin-right: -8px;
  margin-left: -8px;
}
</style>
