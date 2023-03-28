<template>
  <b-sidebar
    id="sidebar"
    backdrop
    shadow
    close-label="bg-light"
  >
    <template #header>
      <img src="/images/logo.png" height="30" alt="Adapters logo">
    </template>

    <div class="px-3 py-2">
      <b-nav vertical>
        <template v-for="(navItem,i) in nav">
          <div v-if="navItem.type===1" :key="i">
            <b-nav-item v-b-toggle="'collapse-'+i" :active="!!navItem.items.find(item=>item.link===$route.path)">
              {{ navItem.name }}
              <b-icon icon="chevron-down" font-scale=".75" />
            </b-nav-item>
            <b-collapse :id="'collapse-'+i" class="ml-3">
              <b-nav-item v-for="(item,j) in navItem.items" :key="j" :to="item.link">
                {{ item.name }}
              </b-nav-item>
            </b-collapse>
          </div>
          <b-nav-item v-if="navItem.type===0" :key="i" :to="navItem.link">
            {{ navItem.name }}
          </b-nav-item>
        </template>
      </b-nav>
    </div>
  </b-sidebar>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'TheSidebar',

  computed: {
    ...mapGetters('modules/application', ['nav'])
  }
}
</script>

<style scoped lang="scss">

</style>
