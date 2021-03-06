<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Rivani Wines</title>

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

<g:if test="${flash.message}">
    <div class="alert alert-info" role="alert">
        ${flash.message}
    </div>
</g:if>


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
                    <li class="active"><g:link controller="ordine" action="carrello">Carrello</g:link></li>

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
                        <h2>Carrello</h2>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End Page title area -->
    
    
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">

                
                <div class="col-md-8">
                    <div class="product-content-right">
                        <div class="woocommerce">

                                <table cellspacing="0" class="shop_table cart">
                                    <thead>
                                        <tr>
                                            <th class="product-name">Prodotto</th>
                                            <th class="product-price">Prezzo</th>
                                            <th class="product-quantity">Quantità</th>
                                            <th class="product-subtotal">Totale</th>
                                        </tr>
                                    </thead>
                                    <tbody>


                                        <g:each in="${lineeOrdine}" var="lineaOrdine">
                                            <tr class="cart_item">

                                                <td class="product-name">
                                                    <a href="single-product.html">${lineaOrdine.annata.toString()}</a>
                                                </td>

                                                <td class="product-price">
                                                    <span class="amount">€ ${lineaOrdine.annata.prezzo.toString()}</span>
                                                </td>

                                                <td class="product-quantity">
                                                    <div class="quantity buttons_added">
                                                        ${lineaOrdine.quantita.toString()}
                                                    </div>
                                                </td>

                                                <td class="product-subtotal">
                                                    <span class="amount">€ ${lineaOrdine.getTotal().toString()}</span>
                                                </td>
                                            </tr>
                                        </g:each>

                                        <tr>
                                            <td class="actions" colspan="6" style="text-align: right">
                                                <h2>
                                                    Totale: € ${carrello.getTotal().toString()}
                                                </h2>
                                                <g:form controller="ordine" action="checkout">
                                                    <input type="submit" value="Procedi" name="proceed" class="checkout-button button alt wc-forward">
                                                </g:form>
                                                <br>
                                                <g:form controller="ordine" action="annullaCarrello">
                                                    <input type="submit" value="Annulla ordine" name="proceed" class="checkout-button button alt wc-forward" style="background-color:#751005">
                                                </g:form>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>


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