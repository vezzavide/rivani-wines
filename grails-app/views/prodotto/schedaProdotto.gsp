<%@ page import="aziendavinicola.Notifica" %>
<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SCHEDA PRODOTTO</title>
    
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

      <!-- Bootstrap -->
      <asset:stylesheet src="shopTemplate/css/bootstrap.min.css"/>

      <!-- Font Awesome -->
      <asset:stylesheet src="shopTemplate/css/font-awesome.min.css"/>

      <!-- Custom CSS -->
      <asset:stylesheet src="shopTemplate/css/owl.carousel.css"/>
      <asset:stylesheet src="shopTemplate/style.css"/>
      <asset:stylesheet src="shopTemplate/css/responsive.css"/>

  </head>
  <body>
   
    <div class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="user-menu">
                        <ul>
                            <g:if test="${session.utente}">
                                <li><g:link controller="utente" action="logout"><i class="fa fa-user"></i>Utente ${session.utente.toString()} (Logout)</g:link></li>
                            </g:if>
                            <g:else>
                                <li><g:link controller="utente" action="login"><i class="fa fa-user"></i> Login</g:link></li>
                            </g:else>
                        </ul>
                    </div>
                </div>
                
                
            </div>
        </div>
    </div> <!-- End header area -->
    

    
    
    <div class="mainmenu-area">
        <div class="container">
            <div class="row">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div> 
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><g:link controller="catalogo" action="catalogo">Home</g:link></li>
                        <li><a href="cart.html">Carrello</a></li>

                    </ul>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->
    
    <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                        <h2>${prodotto.nome.capitalize()}</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">

                
                <div class="col-md-8">
                    <div class="product-content-right">

                        
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="product-images">
                                    <div class="product-main-img">
                                        <asset:image src="shopTemplate/img/product-2.jpg"></asset:image>
                                    </div>
                                    

                                </div>
                            </div>
                            
                            <div class="col-sm-6">
                                <div class="product-inner">

                                    <!-- Elenco annate -->
                                    <g:each in="${prodotto.annate.sort()}" var="annata">
                                        <g:if test="${annata.giacenza == 0}">

                                                <g:if test="${notificheAnno.contains(annata.anno)}">
                                                    <g:form controller="notifica" action="delete" class="cart">
                                                        <h2>Annata ${annata.anno}</h2>
                                                        <div class="product-inner-price">
                                                            <ins>€ ${annata.prezzo.toString()} (disponibili: ${annata.giacenza})</ins>
                                                        </div>
                                                        <button type="button" class="notifica_button" style="background: none repeat scroll 0 0 #1dd931;">&#10003 Sei già iscritto al servizio di notifica</button>
                                                        <g:hiddenField name="id" value="${aziendavinicola.Notifica.findByClienteAndAnnata(session.utente, annata).id}"></g:hiddenField>
                                                        <button type="submit" class="notifica_button" style="background: none repeat scroll 0 0 #d91708;">Annulla iscrizione</button>
                                                    </g:form>
                                                </g:if>
                                                <g:elseif test="${session.utente == null}">
                                                    <h2>Annata ${annata.anno}</h2>
                                                    <div class="product-inner-price">
                                                        <ins>€ ${annata.prezzo.toString()} (disponibili: ${annata.giacenza})</ins>
                                                    </div>
                                                    <g:link controller="utente" action="login">
                                                        <button type="Button" class="notifica_button" style="background: none repeat scroll 0 0 #d96d1c;">Effettua il login per iscriverti al servizio di notifica</button>

                                                    </g:link>
                                                </g:elseif>
                                                <g:else>
                                                    <g:form controller="notifica" action="save" class="cart">
                                                        <h2>Annata ${annata.anno}</h2>
                                                        <div class="product-inner-price">
                                                            <ins>€ ${annata.prezzo.toString()} (disponibili: ${annata.giacenza})</ins>
                                                        </div>
                                                        <g:hiddenField name="cliente" value="${session.utente.id}"></g:hiddenField>
                                                        <g:hiddenField name="annata" value="${annata.id}"></g:hiddenField>
                                                        <button type="submit" class="notifica_button" style="background: none repeat scroll 0 0 #d96d1c;">Notificami per nuovi arrivi</button>

                                                    </g:form>
                                                </g:else>
                                        </g:if>
                                        <g:else>
                                            <g:form action="" class="cart">
                                                <h2>Annata ${annata.anno}</h2>
                                                <div class="product-inner-price">
                                                    <ins>€ ${annata.prezzo.toString()} (disponibili: ${annata.giacenza})</ins>
                                                </div>
                                                <div class="quantity">
                                                    <input type="number" size="4" class="input-text qty text" title="Qty" value="0" name="quantity" min="0" step="1" max="${annata.giacenza}">
                                                </div>

                                                <button class="add_to_cart_button" type="submit">Aggiungi al carrello</button>
                                            </g:form>
                                        </g:else>
                                        <br><br><br>

                                    </g:each>
                                    

                                    
                                    <div role="tabpanel">
                                        <p>
                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane fade in active" id="home">
                                                <h1>Caratteristiche del prodotto</h1>
                                                ${prodotto.caratteristiche.capitalize()}
                                            </div>
                                            <div role="tabpanel" class="tab-pane fade" id="profile">

                                            </div>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                        
                        
                        
                    </div>                    
                </div>
            </div>
        </div>
    </div>


     <div class="footer-bottom-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="copyright">
                        <p>&copy; 2015 Rivani Wines. All Rights Reserved.</p>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End footer bottom area -->


      <!-- Latest jQuery form server -->
      <asset:javascript src="jquery-3.3.1.min.js"/>

      <asset:javascript src="bootstrap.min.js"/>

      <!-- jQuery sticky menu -->
      <asset:javascript src="shopTemplate/js/owl.carousel.min.js"/>
      <asset:javascript src="shopTemplate/js/jquery.sticky.js"/>

      <!-- jQuery easing -->
      <asset:javascript src="shopTemplate/js/jquery.easing.1.3.min.js"/>

      <!-- Main Script -->
      <asset:javascript src="shopTemplate/js/main.js"/>
  </body>
</html>