<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<asset:stylesheet src="shopTemplate/style__.css"/>
<asset:javascript src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"/>
<asset:javascript src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"/>
<asset:stylesheet src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
	
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->



    <!-- Login Form -->
    <g:form name="loginForm" action="autenticaUtente">
      <input type="text" id="login" class="fadeIn second" name="email" placeholder="Email">
      <input type="text" id="password" class="fadeIn third" name="password" placeholder="Password">
      <input type="submit" class="fadeIn fourth" value="Accedi">
    </g:form>

    <!-- Remind Passowrd -->

	<div id="formFooter">
	  <g:link class="underlineHover" action="signup">Registrazione</g:link>
    </div>

  </div>
</div>