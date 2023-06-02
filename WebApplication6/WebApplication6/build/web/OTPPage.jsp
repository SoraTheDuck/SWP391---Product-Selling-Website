<%-- 
    Document   : OTPPage
    Created on : May 18, 2023, 2:05:21 AM
    Author     : toden
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/OTPPage.css">
        <%@include file="component/header.jsp" %>
    </head>
    <body>
        <div class="container height-100 d-flex justify-content-center align-items-center"> 
            <div class="position-relative"> 
                <form action="OTP" method="post">
                    <div class="card p-2 text-center"> 
                        <h6>Please enter the one time password <br> to verify your account</h6> 
                        <div> 
                            <span>A code has been sent to</span> 
                            <span>${forgotPassEmail}</span> 
                        </div> 
                        <div id="otp" class="inputs d-flex flex-row justify-content-center mt-2"> 
                            <input class="m-2 text-center form-control rounded" type="text" name="otp" maxlength="1" /> 
                            <input class="m-2 text-center form-control rounded" type="text" name="otp" maxlength="1" /> 
                            <input class="m-2 text-center form-control rounded" type="text" name="otp" maxlength="1" /> 
                            <input class="m-2 text-center form-control rounded" type="text" name="otp" maxlength="1" /> 
                            <input class="m-2 text-center form-control rounded" type="text" name="otp" maxlength="1" /> 
                            <input class="m-2 text-center form-control rounded" type="text" name="otp" maxlength="1" /> 
                        </div> 
                        <span style="color: red">${requestScope.err}</span>
                        <div class="mt-4"> 
                            <button class="btn btn-danger px-4 validate">Validate</button> </div> </div> <div class="card-2"> 
                        <div class="content d-flex justify-content-center align-items-center"> 
                            <span>Didn't get the code</span> 
                            <a href="OTP" class="text-decoration-none ms-3">Resend</a> 
                        </div> 
                        <div class="content d-flex justify-content-center align-items-center">
                            <a href="#" class="text-decoration-none ms-3">Back to Home</a>      
                        </div>
                    </div> 
                </form>

            </div>
        </div>

        <script>
            document.addEventListener("DOMContentLoaded", function (event) {

                function OTPInput() {
                    const inputs = document.querySelectorAll('#otp > *[id]');
                    for (let i = 0; i < inputs.length; i++) {
                        inputs[i].addEventListener('keydown', function (event) {
                            if (event.key === "Backspace") {
                                inputs[i].value = '';
                                if (i !== 0)
                                    inputs[i - 1].focus();
                            } else {
                                if (i === inputs.length - 1 && inputs[i].value !== '') {
                                    return true;
                                } else if (event.keyCode > 47 && event.keyCode < 58) {
                                    inputs[i].value = event.key;
                                    if (i !== inputs.length - 1)
                                        inputs[i + 1].focus();
                                    event.preventDefault();
                                } else if (event.keyCode > 64 && event.keyCode < 91) {
                                    inputs[i].value = String.fromCharCode(event.keyCode);
                                    if (i !== inputs.length - 1)
                                        inputs[i + 1].focus();
                                    event.preventDefault();
                                }
                            }
                        });
                    }
                }
                OTPInput();


            });
        </script>
    </body>
</html>
