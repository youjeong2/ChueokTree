import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About.vue'

// For Cafe Board
import BoardListPage from '../views/board/BoardListPage.vue'
import BoardRegisterPage from '../views/board/BoardRegisterPage.vue'
import BoardModifyPage from '../views/board/BoardModifyPage.vue'
import BoardReadPage from '../views/board/BoardReadPage.vue'

// For Login System
import LoginPage from '../views/member/LoginPage.vue'
import AdminSetupPage from '../views/member/AdminSetupPage.vue'

// Vuetify
import VuetifyBoard from '../views/board/VuetifyBoard.vue'

// VuetifyBoardListPage
import VuetifyBoardListPage from '../views/board/VuetifyBoardListPage.vue'

// CrawlCategory
import CrawlCategory from '../views/CrawlCategory.vue'

import Main from '../views/Main.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: About
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    // component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/board',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  },
  {
    path: '/board/create',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  },
  {
    path: '/board/boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/board/boardNo/edit',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      // 이 옵션을 설정하면 route.params가 컴포넌트의 props에 자동 설정됨
      default: true
    }
  },
  {
    path: '/LoginPage',
    name: 'LoginPage',
    components: {
      default: LoginPage
    }
  },
  {
    path: '/AdminSetupPage',
    name: 'AdminSetupPage',
    components: {
      default: AdminSetupPage
    }
  },
  {
    path: '/VuetifyBoard',
    name: 'VuetifyBoard',
    components: {
      default: VuetifyBoard
    }
  },
  {
    path: '/VuetifyBoardListPage',
    name: 'VuetifyBoardListPage',
    components: {
      default: VuetifyBoardListPage
    }
  },
  {
    path: '/CrawlCategory',
    name: 'CrawlCategory',
    components: {
      default: CrawlCategory
    }
  },
  {
    path: '/Main',
    name: 'Main',
    components: {
      default: Main
    }
  }
]
const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
