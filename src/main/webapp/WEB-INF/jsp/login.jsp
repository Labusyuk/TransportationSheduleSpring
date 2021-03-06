<%--
  Created by IntelliJ IDEA.
  User: labus
  Date: 26.11.2019
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html >
<head>
    <meta charset="UTF-8">
    <title>Gemicle - Authentication</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900|Material+Icons'>

    <link rel="stylesheet" href="assets/login/css/style.css">


</head>

<body>

<!-- Form-->
<div class="form">
    <div class="form-toggle"></div>
    <div class="form-panel one">
        <div class="form-header">
            <h1>Account Login</h1>
        </div>
        <div class="form-content">
            <form method="post" class="User" action="/j_spring_security_check">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" required="required"/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required="required"/>
                </div>
                <div class="form-group">
                    <label class="form-remember">
                        <input type="checkbox"/>Remember Me
                    </label><a class="form-recovery" href="#">Forgot Password?</a>
                </div>
                <div style="text-align: center;"><b style="color: rgb(95, 11, 11);">${userNotExist}</b></div>
                <div style="text-align: center;"><b style="color: rgb(0,7,95);"><a href="/login/google">Sign in with your google account</a></b></div>
                <div class="form-group">
                    <button type="submit">Log In</button>
                </div>
            </form>
        </div>
    </div>
    <div class="form-panel two">
        <div class="form-header">
            <h1>Register Account</h1>
        </div>
        <div class="form-content">
            <form method="post" class="User" action="/registration">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" id="usernameReg" name="username" required="required"/>
                </div>
                <div style="text-align: center;"><b style="color: rgb(95, 11, 11);"> ${usernameAlreadyInUse}</b></div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="passwordReg" name="password" required="required"/>
                </div>
                <div class="form-group">
                    <label for="confirmPasswordReg">Confirm Password</label>
                    <input type="password" id="confirmPasswordReg" name="confirmPassword" required="required"/>
                </div>
                    <div style="text-align: center;"><b style="color: rgb(95, 11, 11);">${confirmPassword}</b></div>
                <div class="form-group">
                    <label for="emailReg">Email Address</label>
                    <input type="email" id="emailReg" name="email" required="required"/>
                </div>
                        <div style="text-align: center;"><b style="color: rgb(95, 11, 11);"> ${emailAlreadyInUse}</b></div>
                <div class="form-group">
                    <button id='register' type="submit">Register</button>
                </div>
            </form>
            <c:remove var="userNotExist"/>
            <c:remove var="usernameAlreadyInUse"/>
            <c:remove var="confirmPassword"/>
            <c:remove var="emailAlreadyInUse"/>
        </div>
    </div>
</div>
<div class="pen-footer"><a href="https://www.behance.net/gallery/30478397/Login-Form-UI-Library" target="_blank"><i class="material-icons">arrow_backward</i>View on Behance</a><a href="https://github.com/andyhqtran/UI-Library/tree/master/Login%20Form" target="_blank">View on Github<i class="material-icons">arrow_forward</i></a></div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://codepen.io/andytran/pen/vLmRVp.js'></script>

<script src="assets/login/js/index.js"></script>

</body>

</html>