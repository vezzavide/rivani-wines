<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CATALOGO</title>
    
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
                        <li class="active"><g:link action="catalogo">Home</g:link></li>
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
                        <h2>Rivani Wines</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">



                <!-- Elenco prodotti -->
                <g:each in="${listaProdottiPrezzi}" var="coppiaProdottoPrezzo">
                    <div class="col-md-3 col-sm-6">
                        <div class="single-shop-product">
                            <div class="product-upper">
                                <asset:image src="shopTemplate/img/product-2.jpg"></asset:image>
                            </div>
                            <h2><g:link controller="prodotto" action="schedaProdotto" id="${coppiaProdottoPrezzo.get(0).id}">${coppiaProdottoPrezzo.get(0)}</g:link></h2>
                            <div class="product-carousel-price">
                                <ins>${coppiaProdottoPrezzo.get(1)}</ins>
                            </div>
                            <div class="product-option-shop">
                                <g:link controller="prodotto" action="schedaProdotto" id="${coppiaProdottoPrezzo.get(0).id}" class="add_to_cart_button">Compra</g:link>
                            </div>
                        </div>
                    </div>
                </g:each>
                
            </div>
            
%{--            <div class="row">
                <div class="col-md-12">
                    <div class="product-pagination text-center">
                        <nav>
                          <ul class="pagination">
                            <li>
                              <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                              </a>
                            </li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li>
                              <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                              </a>
                            </li>
                          </ul>
                        </nav>                        
                    </div>
                </div>
            </div>--}%
        </div>
    </div>



    <div class="footer-bottom-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="copyright">
                       <p>&copy; 2015 Rivani Wines. All Rights Reserved. </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
   
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