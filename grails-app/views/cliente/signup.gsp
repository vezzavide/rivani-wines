<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!------ Include the above in your HEAD tag ---------->
    %{--<link rel="stylesheet" href="style__.css">--}%
    %{--<asset:stylesheet src="shopTemplate/css/bootstrap.min.css"/>--}%
<asset:stylesheet src="shopTemplate/style__.css"/>
<asset:javascript src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"/>
<asset:javascript src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"/>
<asset:stylesheet src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
	
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->



    <!-- Login Form -->
    <g:form name="signupForm" action="save">
      <input type="text" id="nome" class="fadeIn second" name="nome" placeholder="Nome">
      <input type="text" id="cognome" class="fadeIn second" name="cognome" placeholder="Conome">
      <input type="text" id="indirizzo" class="fadeIn second" name="indirizzo" placeholder="Indirizzo">
      <input type="text" id="e-mail" class="fadeIn second" name="email" placeholder="E-mail">
	  <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
	  
      <input type="submit" class="fadeIn fourth" value="Registrati">
    </g:form>



  </div>
</div>