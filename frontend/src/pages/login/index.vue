<template>
  <div>
    <div class="loginBar">
      <div class="ID">
        ID <input type="text" class="inputLogin" placeholder="user id"><br>
      </div>
      <div class="PW">
        PW <input type="text" class="inputLogin" placeholder="Password"><br>
      </div>
      <div class="loginButton">
        <input type="button" value="Log In" id="onlogin">
      </div>
    </div>
  </div>
</template>

<script>
export default {
  
}
</script>

<style>
  .loginBar {
    width: 400px;
    height: 225px;
    border-radius: 43px;
    background-color: rgb(232, 232, 232);
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    box-shadow: 5px 5px 5px gray;
  }
  .ID, .PW {
    text-align: center;
    position: relative;
    top: 25%;
    left: 50%;
    transform: translate(-50%, -50%);
  }
  .PW {
    left: 49%
  }
  #onlogin {
    width: 114px;
    height: 45px;
    border: none;
    background-color: #6b6b6b;
    color: white;
    border-radius: 64px;
    font-size: 15px;
    box-shadow: 2px 2px 2px  #202020;
  }
  #onlogin:hover, #onlogin:checked {
    box-shadow: 2px 2px 2px  #202020 inset;
  }
  .loginButton {
    text-align: center;
    position: relative;
    top: 25%;
    left: 50%;
    transform: translate(-50%, -50%);
  } 
  .inputLogin {
    width: 225px;
    height: 28px;
    margin: 15px;
    padding: 0px 10px;
    border: none;
  }
</style>