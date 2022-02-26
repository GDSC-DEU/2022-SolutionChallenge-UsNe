<template>
  <div class="home"> 
    <nav>
      <router-link to="/" class="navLogo"> UsNe </router-link>
      <ul>
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
export default {
}
</script>

<style scoped>
  .navLogo, .navitem {
    text-decoration-line: none;
    color: white;
  }
  .navLogo {
    padding-top: 8px;
  }
  .routerView{
    width: 100%;
  }
  nav {
    width: 100%;
    height: 50px;
    margin-top: 50px;
    padding: 10px 50px;
    background-color: rgba(0, 0, 0, 0.7);
  }
  .navLogo, ul li {
    float: left;
    font-size: 35px;
  }
  ul li {
    margin-left: 60px;
    list-style-type: none;
    font-size: 20px;
  }
</style>