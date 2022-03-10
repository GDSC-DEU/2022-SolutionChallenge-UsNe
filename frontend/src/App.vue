<template>
  <div class="home"> 
    <nav>
      <ul>
        <li>
          <router-link to="/" class="navLogo"> USNE </router-link>
        </li>
        <li>
          <router-link to="/accountbook" class="navitem"> Account Book </router-link>
        </li>
        <li>
          <router-link to="/data" class="navitem"> Data </router-link>
        </li>
        <li>
          <router-link to="/community" class="navitem"> Community </router-link>
        </li>
        <li>
          <router-link to="/preferences" class="navitem"> Preferences </router-link>
        </li>
        <li>
          회원 프로필
          <button @click="onLogout">LogOut</button>
        </li>
      </ul>
    </nav>
    <div>
      <router-view 
        class="routerView"
      />
    </div>
  </div>
</template>

<script scoped>
import { postLogout } from "@/api/index.js";
export default {
  methods: {
    async onLogout() {
      const logoutBody = {
        "body": {}
      }
      console.log("실행됨");
      const { data } = await postLogout(logoutBody);
      console.log(data);
    }
  },
}
</script>

<style>
  * {
    font-family:serif; 
  }
  .navLogo, .navitem {
    text-decoration-line: none;
    color: rgb(189, 189, 189);
  }
  .navitem:hover {
    color: white;
  }
  .routerView{
    width: 100%;
    margin-top: 60px;
  }
  nav {
    margin-top: 50px;
    width: 100%;
    background-color: rgba(0, 0, 0, 0.6);
  }
  .navLogo {
    font-size: 30px;
    color: white;
  }
  ul li {
    text-align: center;
    list-style-type: none;
    font-size: 18px;
    float: left;
  }
  ul {
    display: inline-grid;
    grid-template-columns: 5fr 2fr 2fr 2fr 2fr 4fr;
    align-items: center;
    width: 100%;
    padding: 0px;
  }
</style>