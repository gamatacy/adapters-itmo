<template>
  <div class="navbar-container">
    <b-container>
      <b-navbar toggleable="lg" class="px-0">
        <b-button v-b-toggle.sidebar class="navbar-toggle d-lg-none shadow-none" variant="link">
          <span class="navbar-toggler-icon" />
        </b-button>

        <b-navbar-brand href="/">
          <img src="/images/logo.png" height="30" alt="Adapters logo">
        </b-navbar-brand>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav class="ml-auto">
            <template v-for="(navItem,i) in nav">
              <b-nav-item-dropdown
                v-if="navItem.type===1"
                :key="i"
                class="mx-3"
                no-caret
                right
                :toggle-class="{active:navItem.items.find(item=>item.link===$route.path)}"
              >
                <template #button-content>
                  {{ navItem.name }}
                  <b-icon icon="chevron-down" font-scale=".75" />
                </template>
                <b-dropdown-item
                  v-for="(item,j) in navItem.items"
                  :key="j"
                  :to="item.link"
                  :active="$route.path===navItem.link"
                >
                  {{ item.name }}
                </b-dropdown-item>
              </b-nav-item-dropdown>
              <b-nav-item
                v-if="navItem.type===0"
                :key="i"
                class="mx-3"
                :to="navItem.link"
                :active="$route.path===navItem.link"
              >
                {{ navItem.name }}
              </b-nav-item>
            </template>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </b-container>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'TheHeader',

  computed: {
    ...mapGetters('modules/application', ['nav'])
  }
}
</script>

<style lang="scss">
@import "assets/scss/variables";

.navbar-container {
  position: sticky;
  top: 0;
  background: var(--light);
  border-bottom: 1px solid var(--gray);
  @media (min-width: 992px) {
    border-bottom: 0;
  }

  .navbar-toggle {
    min-width: 0;
    padding: 0;
  }
}

.navbar .nav-item, .b-sidebar .nav-item {
  &.not-collapsed, &.show {
    svg {
      transform: rotate(180deg);
    }
  }

  svg {
    transition: transform .2s ease-in-out;
    margin-top: 4px;
    margin-left: 4px;
  }

  .nuxt-link-active, .nav-link.active {
    text-shadow: .25px 0 .1px, -.25px 0px .1px;
  }

  .nav-link {
    outline: none;
    color: var(--dark);
    padding: 0.5rem 0;
    transition: all .2s ease-in-out;
    display: flex;
    align-items: center;

    &:hover {
      color: var(--primary);
    }
  }
}
</style>
