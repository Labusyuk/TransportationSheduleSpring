<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Анимация чисел</title>
    <link rel="stylesheet" href="./assets/info/css/style.css">
</head>

<body>
    <div style="text-align: center;"><img src="./assets/info/img/gemicle.jpg" alt="" /></div>
    <div class="benefits">
        <div class="benefits__inner">
            <h2 class="benefits__header">
                О компании в цифрах
            </h2>
            <div class="benefits__element">
                <img class="benefits__icon" src="./assets/info/img/tram1.png" alt="Сотрудники">
                <p class="benefits__number">${countTram}</p>
                <p class="benefits__title">Трамваїв</p>
            </div>
            <div class="benefits__element">
                <img class="benefits__icon" src="./assets/info/img/trolley1.png" alt="Проекты">
                <p class="benefits__number">${countTrolley}</p>
                <p class="benefits__title">Тролейбусів</p>
            </div>
            <div class="benefits__element">
                <img class="benefits__icon" src="./assets/info/img/bus1.png" alt="Опыт">
                <p class="benefits__number">${countBus}</p>
                <p class="benefits__title">Автобусів</p>
            </div>
			<div class="benefits__element">
                <img class="benefits__icon" src="./assets/info/img/workers.svg" alt="Сотрудники">
                <p class="benefits__number">${countUser}</p>
                <p class="benefits__title">Користувачів в БД</p>
            </div>
        </div>
    </div>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script src="./assets/info/js/jquery.spincrement.min.js"></script>
    <script src="./assets/info/js/custom.js"></script>
</body>

</html>
