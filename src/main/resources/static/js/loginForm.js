'use strict';

const loginSmile = document.querySelector(".login__smile");
const loginForm = document.querySelector(".login__form");
const loginBtn = document.querySelector(".btns--login");

loginForm.addEventListener('input', (e) => {
    const memberId = document.querySelector("#login__id").value;
    const memberPw = document.querySelector("#login__pw").value;

    if (memberId && memberPw) {
        loginSmile.style.color = "#70a995";
        loginBtn.style.backgroundColor = "#70a995";
    }
    else{
        loginSmile.style.color = "#cc786e";
        loginBtn.style.backgroundColor = "#cc786e";
    }
});