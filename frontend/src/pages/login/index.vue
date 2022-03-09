<template>
  <div>   
    <div class="loginBar">
      <label> 회원 ID : </label>
      <input type="text" class="inputLogin" v-model="userId">
      <label> 비밀번호 : </label>
      <input type="password" class="inputLogin" v-model="userPassword">
      <div class="loginButton">
        <input type="submit" value="Log In" id="onlogin" @click="submitLogin">
      </div>
    </div>
  </div>
</template>

<script>
import { loginUser } from "@/api/index";

export default {
  data() {
    return {
      userId: "",
      userPassword: ""
    }
  },
  methods: {
    async submitLogin() {
      console.log("submitLogin실행됨")
      const userData = {
        userId: this.userId,
        userPassword: this.userPassword
      };
      const { data } = await loginUser(userData);
      console.log(data);
      this.$router.push("/accountbook")
      this.initForm();
    },
    initForm() {
      this.userId = "";
      this.userPassword = "";
    },
  },
}
</script>

<style scoped>
  div > input {
    border: none;
    border-radius: 2px;
    height: 16px;
    width: 170px;
    padding: 5px;
  }
  .loginButton {
    grid-column-start: 1;
    grid-column-end: 3;
  }
  .loginBar {
    display: grid;
    grid-template-columns: 40% 60%;
    grid-template-rows: 3fr 3fr 4fr;
    align-items: center;
    text-align: center;
    padding: 20px;
  }
  .loginBar {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 350px;
    height: 200px;
    border-radius: 43px;
    background-color: rgb(232, 232, 232);
    box-shadow:0 5px 10px rgba(0, 0, 0, 0.5)
  }
  #onlogin {
    width: 110px;
    height: 45px;
    border: none;
    background-color: #6b6b6b;
    color: white;
    border-radius: 64px;
    font-size: 15px;
    box-shadow:0 2px 5px rgba(0, 0, 0, 0.5)
  }
  #onlogin:hover, #onlogin:checked {
    box-shadow:0 2px 5px rgba(0, 0, 0, 0.5) inset;
  }
</style>