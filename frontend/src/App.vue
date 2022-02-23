<template>
  <div>
    <nav>
      <router-link to="/" class="navLogo"> UsNe </router-link>
      <ul>
        <li>
          <router-link to="/accountbook"> Account Book </router-link>
        </li>
        <li>
          <router-link to="/data"> Data </router-link>
        </li>
        <li>
          <router-link to="/community"> Community </router-link>
        </li>
        <li>
          <router-link to="/preferences"> Preferences </router-link>
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

<script>
export default {
}
</script>

<style>
  .routerView{
    width: 100%;
    position: absolute;
    top: 20%;
  }

  nav {
    width: 100%;
    height: 50px;
  }
  .navLogo {
    position: relative;
    top: 50px;
    left: 10%;
    font-size: 35px;
  }
  ul li {
    margin-left: 60px;
    position: relative;
    top: 3px;
    left: 25%;
    list-style-type: none;
    float: left;
    font-size: 20px;
  }
</style>