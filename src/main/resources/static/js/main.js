'use strict';

//Navbar 토글버튼 클릭 처리
const navbarMenu = document.querySelector('.header__menus__main');
const navbarToggle = document.querySelector('.header__toggle');
navbarToggle.addEventListener('click', () => {
  navbarMenu.classList.toggle('open');
});

//Navbar 메뉴 클릭시 메뉴를 자동으로 닫아줌
navbarMenu.addEventListener('click', () => {
  navbarMenu.classList.remove('open');
});
