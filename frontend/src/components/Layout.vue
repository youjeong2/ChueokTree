<template>
  <v-app id="inspire">
    <!-- v-app-bar는상단 메뉴바 -->
    <v-card class="overflow-hidden">
      <v-app-bar app height="150px" clipped-right color="#7B1FA2" dark hide-on-scroll scroll-target="#scrolling-techniques-4" >
        <!-- 네비게이션 drawer가 v-list를 icon과 drawer로 서포트
         toolbar는 상단에 이름 보여줌
         spacer은 컴포넌트 사이에 공간을 만들고 싶을 때 slot-name="menubar"을 서포트함
         슬롯으로 메뉴바를 연결하는거는 크롤링카테고리의 menubar정보를 여기에 연결하겠다는 뜻-->
          <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
          <v-toolbar-title><div @click="home" class="home">C h u e o k T r e e</div></v-toolbar-title>
          <v-spacer></v-spacer>
        <slot name="menubar"></slot>
      </v-app-bar>
    </v-card>
    <v-navigation-drawer v-model="drawer" app>
      <!--list-dense는 리스트 정렬
      action안에 icon 모양넣을 수 있고 content안에 홈으로 이동누르면 이동할 수 있는거 넣을 수 있음
      mdi-exit은 아이콘 모양 / 포토샵으로 만들 수 있음-->
      <v-list-item class="layout">
        <v-list-item-content>
          <v-list-item-title class="title">
            ChueokTree
          </v-list-item-title>
          <v-list-item-subtitle>
            Blueberry.com
          </v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>
      <v-divider></v-divider>

      <v-list dense>
        <v-list-item @click.stop="left = !left">
          <v-list-item-action>
            <v-icon>home-app</v-icon>
            </v-list-item-action>
            <v-list-item-content>
            <v-list-item-title @click="home">HOME</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>

      <v-list dense>
        <v-list-item @click.stop="left = !left">
          <v-list-item-action>
            <v-icon>home-app</v-icon>
            </v-list-item-action>
            <v-list-item-content>
            <v-list-item-title @click="about">OFFICIAL</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>

      <v-list dense>
        <v-list-item @click.stop="left = !left">
          <v-list-item-action>
          <v-icon></v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title @click="community">COMMUNITY</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>

      <v-list dense>
        <v-list-item @click.stop="left = !left">
          <v-list-item-action>
          <v-icon></v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title @click="category">TOP NEWS</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>

      <!--<v-list dense>
        <v-list-item @click.stop="left = !left">
          <v-list-item-action>
          <v-icon></v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title @click="tourist">TOURIST</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>-->
    </v-navigation-drawer>
    <!-- 크롤링카테고리에서 보면 template #content Layout으로 감싸져서 여기로 전달할 수 있게함
     크롤링한 리스트 정보를 가져오고 리스트넘버랑 제목을 뿌려주는 것 -->

    <v-container>
     <div class="col-md-100 col-lg-100 col-100">
     <div class="v-card v-card--flat v-sheet v-sheet--outlined theme--light">
      <slot name="content" id ="font">
      </slot>
      </div>
      </div>
    </v-container>

    <!-- 하단 부분 &copy가 coportaition C 가 되는 것 -->
    <v-footer app color="#7B1FA2" class="white--text">
      <v-spacer></v-spacer>
      <span>&copy; chueoktree</span>
    </v-footer>
  </v-app>
</template>

<script>
import router from '../router'

export default {
  // -data  return방법 이 방법 데이터 초기화 하는 방법!2가지
  data: () => ({
    drawer: false,
    left: false
  }),
  // 라우터가 루트라면 ~로 보내고 그게 아니라면 ~로 보내기
  methods: {
    home () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    },
    community () {
      (window.location.pathname !== '/VuetifyBoardListPage') ? router.push('/VuetifyBoardListPage') : router.go(0)
    },
    tourist () {
      (window.location.pathname !== '/About') ? router.push('/About') : router.go(0)
    },
    category () {
      (window.location.pathname !== '/CrawlCategory') ? router.push('/CrawlCategory') : router.go(0)
    },
    about () {
      (window.location.pathname !== '/VuetifyBoard') ? router.push('/VuetifyBoard') : router.go(0)
    }
  }
}

</script>

<!--<style>
#inspire {
 height:300px
}
</style>-->

<style>
div.home {
  font-family: "Lucida Console", Courier, monospace;
},
v-list-item.layout {
  font-family: "Lucida Console", Courier, monospace;
}

</style>
