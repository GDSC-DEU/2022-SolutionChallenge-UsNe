<template>
    <div>
        <div class="modalBackground">
        <div class="modalBox">
            <div>
            <div>
                <h1>Add</h1>
            </div>
            <div>
                <div>
                    소비 용도 <br>
                    <hr>
                    <button value="식비">식비</button>
                    <button value="교통비">교통비</button>
                    <button value="생활비">생활비</button>
                    <button value="문화활동">문화활동</button>
                    <button value="+">+</button>
                    <br><br>
                </div>
                <div>
                    사용 수단 <br>
                    <hr>
                    <button value="카드">카드</button>
                    <button value="현금">현금</button>
                    <button value="계좌이체">계좌이체</button>
                    <button value="상품권">상품권</button>
                    <button value="+">+</button>
                    <br><br>
                </div>
                <div>
                    수입/지출 <br>
                    <hr>
                    <button value="in">In</button>
                    <button value="out">Out</button>
                    <br><br>
                </div>
                <div class="inputMoney">
                    금액 : 
                    <input type="text" id="money"> 
                    원
                    <br><br>
                </div>
                <div class="inputDate">
                    날짜 : 
                    <input type="number" id="dateYear"> 
                    
                    <br><br>
                </div>
                <div class="end">
                    <div class="footer">
                        <button type="button">input</button>
                        <button type="button" @click="onClose">close</button>
                    </div>
                </div>
            </div>
            </div>
        </div>
    </div>
    </div>
</template>

<script>
export default {
   setup(props, {emit}) {
       const onClose = () => {
           emit('close');
       }
       return {
           onClose
       }
   }
}
</script>

<style scoped>
    .inputMoney, .inputDate {
        margin: 10px;
        margin-left: 0;
        text-align: center;
    }
    #money {
        width: 130px;
        height: 18px;
        border: solid 1px gray;
        margin: 5px;
    }
    .end {
        width: 380px;
        height: 190px;
    }
    .footer {
        position: absolute;
        right: 15px;
        bottom: 15px;
    }
    h1 {
        text-align: center;
    }
    .modalBackground {
        width: 100%;
        height: 100%;
        position: fixed;
        top: 0;
        left: 0;
        background-color: rgba(0, 0, 0, 0.5);
    }
    .modalBox {
        width: 380px;
        height: 600px;
        padding: 20px;
        border-radius: 10px;
        position: fixed;
        top: 10%;
        left: 36%;
        background-color: white;
    }
    button {
        width: 70px;
        padding: 4px;
        margin: 5px;
        border-radius: 35px;
        border: none;
        color: black;
    }
</style>