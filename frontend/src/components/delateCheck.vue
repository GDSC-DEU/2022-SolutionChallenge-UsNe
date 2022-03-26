<template>
<div>
    <div class="checkModal">
    정말 그룹을 삭제하시겠습니까?
    </div>
    <div class="yes">
        <button>YES</button>
    </div>
    <div class="no"></div>
        <button>NO</button>
    
</div>
</template>

<script>
export default {
    
}
</script>

<style scoped>
.friendFace {
    position: absolute;
    text-align: center; 
    top: 50%;
    left: 50%;
    width: 500px;
    height: 400px;
    padding: 80px;
    background-color: rgb(255, 255, 255);
    border-radius: 10px;
    box-shadow: 0 2px 3px 0 rgba(34, 36, 38, 0.15);
    transform: translateX(-50%) translateY(-50%);
}
.yes {
     width: 87px;
    height: 25px;
    margin: 5px;
    border-radius: 45px;
    border: solid 0.5px blue;
    background-color: white;
    text-align: center;
    font-size: 12px;
}
.no {
     width: 87px;
    height: 25px;
    margin: 5px;
    border-radius: 45px;
    border: solid 0.5px red;
    background-color: white;
    text-align: center;
    font-size: 12px;
}
</style>